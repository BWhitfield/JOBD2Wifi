package util;

import static org.junit.Assert.*;

import java.io.IOException;
import java.io.InputStream;

import main.Constants;

import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

public class ResponseUtilityHelperTests {

	IResponseUtilityHelper _testObject;
	
	@Before
	public void setup(){
		MockitoAnnotations.initMocks(this);
		_testObject = new ResponseUtilityHelper();
	}
	
	@Test
	public void trimStringData_CR(){
		String actual = _testObject.trimStringData("expected" + Constants.CR);
		
		assertEquals("expected", actual);
	}

	@Test
	public void trimStringData_LF(){
		String actual = _testObject.trimStringData("expected" + Constants.LF);
		
		assertEquals("expected", actual);
	}

	@Test
	public void trimStringData_PROMPT(){
		String actual = _testObject.trimStringData("expected" + Constants.PROMPT);
		
		assertEquals("expected", actual);
	}
}
