/**
 * 
 */
package boot;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.vip.dw.model.Student;

/**
 * @author fang08.li
 *
 */
public class JSONTest {
	
	public static void main(String[] args) throws JsonProcessingException{
		
		ObjectMapper objectMapper=new ObjectMapper();
		
		objectMapper.setSerializationInclusion(Include.NON_NULL);
		
		objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
		
		boolean canSerialize = objectMapper.canSerialize(Student.class);
		
		
		Student syudent=new Student();
		//if(canSerialize){
			
			System.out.println(objectMapper.writeValueAsString(syudent));
		//}
		
		
	}

}
