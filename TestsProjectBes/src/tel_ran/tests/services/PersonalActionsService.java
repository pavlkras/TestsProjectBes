package tel_ran.tests.services;
import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import tel_ran.tests.entitys.EntityQuestionAttributes;
import tel_ran.tests.entitys.EntityTest;
import tel_ran.tests.services.common.ICommonData;
import tel_ran.tests.services.interfaces.IPersonalActionsService;
import tel_ran.tests.services.testhandler.IPersonTestHandler;
import tel_ran.tests.services.testhandler.PersonTestHandler;
import tel_ran.tests.services.utils.FileManagerService;
import tel_ran.tests.token_cipher.TokenProcessor;

public class PersonalActionsService extends CommonServices implements IPersonalActionsService {	
	
	@Autowired
	TokenProcessor tokenProcessor;
	
	private long testID;
	private long companyID;
	////
	@Override
	public boolean GetTestForPerson(String testPassword) {	// creation test for person
		boolean actionResult = false;
		EntityTest tempRes = (EntityTest) em.createQuery("SELECT test FROM EntityTest test WHERE test.password='"+testPassword+"'").getSingleResult();
		if(tempRes != null){
			testID = tempRes.getTestId();
			companyID = 0;//tempRes.getCompanyId();      //------ to do ?????
			getTestResultsHandler(companyID, testID);
			actionResult = true;
		}

		return actionResult;
	}
	////-------  Processing  ----------------// START //
	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
	public String getNextQuestion(long testId){
		String question = null; 
		EntityTest test = em.find(EntityTest.class, testId);

		if(!test.isPassed()){
			if(test.getStartTestDate()==0){
				test.setStartTestDate(new Date().getTime());
				em.persist(test);
			}
			IPersonTestHandler testResultsJsonHandler = getTestResultsHandler(test.getEntityCompany().getId(), testId);

			question = testResultsJsonHandler.next();
			if ( question == null ){
				//TODO new Thread needed
				testResultsJsonHandler.analyzeAll();

				test.setAmountOfCorrectAnswers(testResultsJsonHandler.getRightAnswersQuantity());
				test.setEndTestDate(new Date().getTime());
				test.setPassed(true);
				em.persist(test);
			}
		}
		return question;
	}

	@Override
	public void setAnswer(long testId, String jsonAnswer){
		
		EntityTest test = em.find(EntityTest.class, testId);

		if(!test.isPassed()){
			getTestResultsHandler(test.getEntityCompany().getId(), testId).setAnswer(jsonAnswer);
		}
	}

	IPersonTestHandler getTestResultsHandler(long companyId, long testId){
		return new PersonTestHandler(companyId, testId, em);
	}
	////-------  Processing  ----------------// END //
	@Override
	public String getToken(String password) {
		// TODO password is potentially dangerous because it is directly the same inside of the request.
		// Check how to write this code without SQL-injection problem !!!
		String token = null;
		EntityTest test = (EntityTest) em.createQuery("Select t from EntityTest t where t.password='" + password +"'" ).getSingleResult();
		if(test != null){
			token = tokenProcessor.encodeIntoToken(test.getTestId(), ICommonData.TOKEN_VALID_IN_SECONDS);
		}
		return token;
	}
	
	public boolean testIsPassed(long testId){
		boolean res = false;
		EntityTest test = null;		
		try{
			test = em.find(EntityTest.class, testId);
			if(test.isPassed()){
				res = true;
			}
		}catch (Exception e){
			e.printStackTrace();
		}

		return res;
	}
	@Override
	public void saveImage(long testId, String image) {
		EntityTest test = em.find(EntityTest.class, testId);

		if(!test.isPassed()){
			FileManagerService.saveImage(test.getEntityCompany().getId(), testId, image);
		}
	}
	@Override
	protected boolean ifAllowed(EntityQuestionAttributes question) {
		
		return false;
	}

	@Override
	protected String getLimitsForQuery() {
		return null;
	}
	
	@Override
	public Map<String, Object> getUserInformation() {		
		return null;
	}
	
}