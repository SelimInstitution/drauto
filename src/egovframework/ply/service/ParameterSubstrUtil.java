package egovframework.ply.service;

public class ParameterSubstrUtil {

	private StringBuffer fullText = new StringBuffer();
	private String regText = "";
	private String resultText = "";
	
	public ParameterSubstrUtil(StringBuffer fullText, String regText){
		
		this.fullText = fullText;
		this.regText = regText;
		
	}
	
	   public String substrResult(){
		if(fullText.indexOf(regText)>-1){
			System.out.println("fullText::"+fullText+"  regText::"+regText+"  indexOf::"+fullText.indexOf(regText));
			resultText = fullText.substring(fullText.indexOf(regText));
		}else{
			resultText = fullText.toString();
		}
		return resultText;
	}
}
