package tel_ran.tests.entitys;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import tel_ran.tests.services.fields.ApplicationFinalFields;
import tel_ran.tests.services.interfaces.IMaintenanceService;

@Entity
public class EntityQuestionAttributes implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	////
	
	////
	@Id @GeneratedValue
	private long id;
	
	////codeQuestionTable
	@ManyToOne
	private EntityQuestion questionId;
	
	////link to the company that has created this question (EntityCompany)
	@ManyToOne	
	private EntityCompany companyId;
	
	////name of MetaCategory (Attention, Programming Task, etc)
	@Column(name = "metaCategory")
	private String metaCategory;
	
	////name of the programming language for Programming Tasks and categories for company-user's questions
	@Column(name = "category1")
	private String category1;
	
	////name of the sub-category (sorts of tasks, like Calculator for Programming Tasks)
	@Column(name = "category2")
	private String category2;
	
	////level of difficulty
	@Column(name = "levelOfDifficulty")
	private int levelOfDifficulty;
	
	////text field for the task description that is used in Programming Tasks and company-user's tasks
	@Column(name = "description", length = 2500)
	private String description; 
	
	////url of the images for generated tests and of the archive with response for programming tasks	
	@Column(name = "fileLocationLink", unique = false, nullable = true, length = 500)
	private String fileLocationLink;
	
	////links to some text fields that can be used for American Tests and Programming Tasks (EntityAnswersText) 
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "questionAttributeId")
	List<EntityAnswersText> questionAnswersList;
		
	////letter of the correct answer (for American Tests)
	@Column(name = "correctAnswer")
	private String correctAnswer;
	
	////total number of responses for American tests
	@Column(name = "numresponses")
	private int numberOfResponsesInThePicture;
	
	////text field for the code stub (Programming Tasks)
	// expired. to use EntityAnswersTest for ProgrammingTasks
	//@Column(name = "codeLine", length = 1500)
	//private String codeLine;
	

	
	////	
	
	
	public EntityQuestionAttributes() {	}
	
	public String getDescription() {
		return description;		
	}
	public void setDescription(String description) {
		this.description = description;
	}	
	public EntityCompany getCompanyId() {
		return companyId;
	}
	public void setCompanyId(EntityCompany companyId) {
		this.companyId = companyId;
	}
//	public String getCodeLine() {
//		return codeLine;
//	}
//	public void setCodeLine(String codeLine) {
//		this.codeLine = codeLine;
//	}

//	public String getLineCod() {
//		return codeLine;
//	}
//	public void setLineCod(String lineCod) {
//		this.codeLine = lineCod;
//	}	
	public EntityQuestion getQuestionId() {
		return questionId;
	}
	public void setQuestionId(EntityQuestion questionId) {
		this.questionId = questionId;
	}
	public String getFileLocationLink() {
		return fileLocationLink;
	}	
	public void setFileLocationLink(String fileLocationLink) {
		this.fileLocationLink = fileLocationLink;
	}

	public String getCategory1() {
		return category1;
	}

	public void setCategory1(String category1) {
		this.category1 = category1;
	}

	public String getCategory2() {
		return category2;
	}

	public void setCategory2(String category2) {
		this.category2 = category2;
	}

	public int getLevelOfDifficulty() {
		return levelOfDifficulty;
	}
	public void setLevelOfDifficulty(int levelOfDifficulty) {
		this.levelOfDifficulty = levelOfDifficulty;
	}
	public String getCorrectAnswer() {
		return correctAnswer;
	}
	public void setCorrectAnswer(String correctAnswer) {
		this.correctAnswer = correctAnswer;
	}
	public List<EntityAnswersText> getQuestionAnswersList() {
		return questionAnswersList;
	}
	public void setQuestionAnswersList(List<EntityAnswersText> questionAnswers) {
		this.questionAnswersList = questionAnswers;
	}
	public int getNumberOfResponsesInThePicture() {
		return numberOfResponsesInThePicture;
	}
	public void setNumberOfResponsesInThePicture(int numberOfResponsesInThePicture) {
		this.numberOfResponsesInThePicture = numberOfResponsesInThePicture;
	}	
	public long getId() {
		return id;
	}	
	public String getMetaCategory() {
		return metaCategory;
	}
	public void setMetaCategory(String metaCategory) {
		this.metaCategory = metaCategory;
	}

	////
	@Override
	public String toString() {
		return questionId.getId()
				+ ApplicationFinalFields.DELIMITER + metaCategory
				+ ApplicationFinalFields.DELIMITER + category1
				+ ApplicationFinalFields.DELIMITER + category2			
				+ ApplicationFinalFields.DELIMITER + levelOfDifficulty
				+ ApplicationFinalFields.DELIMITER + description
				+ ApplicationFinalFields.DELIMITER + fileLocationLink	
				+ ApplicationFinalFields.DELIMITER + correctAnswer
				+ ApplicationFinalFields.DELIMITER + numberOfResponsesInThePicture
				+ ApplicationFinalFields.DELIMITER + companyId;
	}
	

}
