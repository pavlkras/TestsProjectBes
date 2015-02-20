package tel_ran.tests.services;

import javax.persistence.Embeddable;

import org.json.simple.JSONObject;

import tel_ran.tests.services.common.CommonData;
@Embeddable
public class EntityTestResultDetails {	
/*
 	�	Test duration  
	�	Number of the questions
	�	Complexity level
	�	Number of the right answers with the percentage 
	�	Number of the wrong answers with the percentage
	�	5 photos made during the test
	*/
	private int duration;
	private int complexityLevel;
	private int quantityRight;
	private int quantityWrong;
	private String pictures;

	public EntityTestResultDetails() {
	}

	@Override
	public String toString() {
		StringBuffer strbuf = new StringBuffer();
		strbuf.append(duration);
		strbuf.append(CommonData.delimiter);
		strbuf.append(complexityLevel);
		strbuf.append(CommonData.delimiter);
		strbuf.append(quantityRight);
		strbuf.append(CommonData.delimiter);
		strbuf.append(quantityWrong);
		strbuf.append(CommonData.delimiter);
		strbuf.append(pictures);
		return strbuf.toString();
	}
//	public JSONObject toJson()
//	{
//		JSONObject json = new JSONObject();
//		json.put("duration",duration);
//		json.put("complexityLevel",complexityLevel);
//		json.put("quantityRight", quantityRight);
//		json.put("quantityWrong", quantityWrong);
//		json.put("pictures", pictures);
//		
//		System.out.println(json);
//		return json;
//	}
	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public int getComplexityLevel() {
		return complexityLevel;
	}

	public void setComplexityLevel(int complexityLevel) {
		this.complexityLevel = complexityLevel;
	}

	public int getQuantityRight() {
		return quantityRight;
	}

	public void setQuantityRight(int quantityRight) {
		this.quantityRight = quantityRight;
	}

	public int getQuantityWrong() {
		return quantityWrong;
	}

	public void setQuantityWrong(int quantityWrong) {
		this.quantityWrong = quantityWrong;
	}

	public String getPictures() {
		return pictures;
	}

	public void setPictures(String pictures) {
		this.pictures = pictures;
	}
	
	public void addPictureLink(String pictureLink) { //http-links with delimiters
		if(this.pictures==null||this.pictures.length() == 0){
			this.pictures = pictureLink;
		}
		else{
			this.pictures += CommonData.delimiter + pictureLink;
		}
	}
}