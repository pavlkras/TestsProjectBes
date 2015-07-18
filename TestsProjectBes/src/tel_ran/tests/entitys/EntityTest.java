package tel_ran.tests.entitys;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class EntityTest {


	////
	@Id
	@GeneratedValue
	private long testId; 	
	private String password;
	private boolean isPassed;
	@Column(name = "cam_prntscr")
	private boolean usesCameraANDPrintScreen;

	private int amountOfCorrectAnswers;
	private int amountOfQuestions;
	////
	////
	private int duration;
	private long startTestDate = 0L;
	private long endTestDate = 0L;
	//
	@ManyToOne
	private EntityCompany entityCompany;
	@ManyToOne
	private EntityPerson entityPerson;
	
	public EntityTest() {}

	public void setAmountOfCorrectAnswers(int amountOfCorrectAnswers) {
		this.amountOfCorrectAnswers = amountOfCorrectAnswers;
	}
	public void setAmountOfQuestions(int amountOfQuestions) {
		this.amountOfQuestions = amountOfQuestions;
	}
//	private JSONArray getJsonArrayImage(String paths){
//		JSONArray ar = new JSONArray();
//		if(!paths.equals(null)||!paths.equals("")){ 
//
//			String[] pathsArray = paths.split(",");  
//			for(String path:pathsArray){					
//				JSONObject jsonObj = new JSONObject();		
//				String file = getFileWithinString(path);
//
//				if(file != null){
//					try {
//						jsonObj.put("picture", file);
//					} catch (JSONException e) {
//						e.printStackTrace();
//					}
//					ar.put(jsonObj);
//				}
//			}
//		}
//		return ar;
//	}
	
//	private JSONArray getJsonArrayCode(String paths, String codeAnalyseResults, String programmingLanguages){
//		JSONArray ar = new JSONArray();
//		if(	!paths.equals(null)&&
//			!paths.equals("")&&
//			!codeAnalyseResults.equals(null)&&
//			!codeAnalyseResults.equals("")&&
//			!programmingLanguages.equals(null)&&
//			!programmingLanguages.equals("")){ 
//
//			String[] pathsArray = paths.split(",");  
//			String[] codeAnalyseResultsArray = codeAnalyseResults.split(",");
//			String[] programmingLanguagesArray = programmingLanguages.split(",");
//			
//			if(pathsArray.length == codeAnalyseResultsArray.length && codeAnalyseResultsArray.length == programmingLanguagesArray.length){
//				for(int i=0; i<pathsArray.length; i++){
//					JSONObject jsonObj = new JSONObject();		
//					
//					String file = getFileWithinString(pathsArray[i]);
//
//					if(file != null){
//						try {
//							jsonObj.put("code", file);
//							jsonObj.put("codeAnalyseResult", codeAnalyseResultsArray[i]);
//							jsonObj.put("programmingLanguage", programmingLanguagesArray[i]);
//						} catch (JSONException e) {
//							e.printStackTrace();
//						}
//						ar.put(jsonObj);
//					}
//				}
//			}
//		}
//		return ar;
//	}

//	public String getFileWithinString(String path){
//		String res = null;
//		BufferedReader in=null;
//		try {
//			in = new BufferedReader(new FileReader(path));
//			String line;
//			StringBuffer stringBuffWithFileContent = new StringBuffer();
//			while((line = in.readLine()) != null){
//				stringBuffWithFileContent.append(line);
//				stringBuffWithFileContent.append("\n");
//			}
//			res = stringBuffWithFileContent.toString();
//		} catch (FileNotFoundException e) {
//		} catch (IOException e) {
//		} finally{
//			try {
//				in.close();
//			} catch (Exception e) {}
//		}
//		return res;
//	}

	public long getTestId() {
		return testId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getAmountOfCorrectAnswers() {
		return amountOfCorrectAnswers;
	}

	public int getAmountOfQuestions() {
		return amountOfQuestions;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public long getStartTestDate() {
		return startTestDate;
	}

	public void setStartTestDate(long startTestDate) {
		this.startTestDate = startTestDate;
	}

	public long getEndTestDate() {
		return endTestDate;
	}

	public void setEndTestDate(long endTestDate) {
		this.duration = (int) (endTestDate - this.startTestDate); //// set duration in m_sec
		this.endTestDate = endTestDate;
	}

	public EntityPerson getEntityPerson() {
		return entityPerson;
	}

	public void setEntityPerson(EntityPerson entityPerson) {
		this.entityPerson = entityPerson;
	}

	public EntityCompany getEntityCompany() {
		return entityCompany;
	}

	public void setEntityCompany(EntityCompany entityCompany) {
		this.entityCompany = entityCompany;
	} 

	public void setPassed(boolean isPassed) {
		this.isPassed = isPassed;
	}
	public boolean isPassed() {
		return isPassed;
	}
	public boolean isUsesCameraANDPrintScreen() {
		return usesCameraANDPrintScreen;
	}
	public void setUsesCameraANDPrintScreen(boolean usesCameraANDPrintScreen) {
		this.usesCameraANDPrintScreen = usesCameraANDPrintScreen;
	}
}
