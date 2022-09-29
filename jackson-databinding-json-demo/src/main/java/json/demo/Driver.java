package json.demo;

import java.io.File;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ObjectMapper mapper = new ObjectMapper();

		try {
			Student student = mapper.readValue(new File("data/sample-full.json"), Student.class);

			System.out.println("First name = " + student.getFirstName());
			System.out.println("Last name = " + student.getLastName());

			Address address = student.getAddress();

			System.out.println("Street = " + address.getStreet());
			System.out.println("City = " + address.getCity());

			for (String lang : student.getLanguages()) {
				System.out.println(lang);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
