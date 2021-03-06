/*
This file is part of raw4j.

raw4j is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

raw4j is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with raw4j.  If not, see <http://www.gnu.org/licenses/>.
*/

package com.cd.reddit.http.requestor;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.cd.reddit.http.requestor.RedditRequestor;
import com.cd.reddit.http.util.RedditApiParameterConstants;
import com.cd.reddit.http.util.RedditApiResourceConstants;
import com.cd.reddit.http.util.RedditRequestInput;
import com.cd.reddit.http.util.RedditRequestResponse;

//@Test notations have been removed to prevent frivolous API calls 
public class RedditRequestorTest {

	private static final String nl = System.getProperty("line.separator");
	
	RedditRequestor testRequestor;
	RedditRequestInput testInput;

	//Throway account for proof-of-concept purposes
	final String testUserAgent = "JavaJerseyTestBot/1.0 by Cory Dissinger";	
	
	@Before
	public void waitForNextRequest(){
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void loginTest(){
		System.out.println(nl);		
		System.out.println("Begin Method: loginTest");
		System.out.println(nl);
		
		List<String> testSegments = new ArrayList<String>();
		
		testSegments.add(RedditApiResourceConstants.API);
		testSegments.add(RedditApiResourceConstants.LOGIN);

		Map<String, String> testBodyParams = new HashMap<String, String>();
		
		testBodyParams.put(RedditApiParameterConstants.API_TYPE, RedditApiParameterConstants.JSON);
		testBodyParams.put(RedditApiParameterConstants.PASSWD, "JavaJerseyTestBot");
		testBodyParams.put(RedditApiParameterConstants.USER, "JavaJerseyTestBot");
		
		RedditRequestInput testInput 
							= new RedditRequestInput(testSegments, 
													 testUserAgent, 
													 null,
													 testBodyParams);
		
		final RedditRequestResponse output = RedditRequestor.executePost(testInput);

		System.out.println(testInput);
		System.out.println(output);		
		assertEquals(output.getStatus(), 200);
	}

	public void subredditsNewTest(){
		System.out.println(nl);		
		System.out.println("Begin Method: subredditsNewTest");
		System.out.println(nl);		
		
		List<String> testSegments = new ArrayList<String>();
		
		testSegments.add(RedditApiResourceConstants.SUBREDDITS);
		testSegments.add(RedditApiResourceConstants.NEW + RedditApiResourceConstants.DOT_JSON);
		
		RedditRequestInput testInput 
							= new RedditRequestInput(testSegments, 
													 testUserAgent);
		
		final RedditRequestResponse output = RedditRequestor.executeGet(testInput);

		System.out.println(testInput);		
		System.out.println(output);		
		assertEquals(output.getStatus(), 200);
	}

	public void subredditsPopularTest(){
		System.out.println(nl);		
		System.out.println("Begin Method: subredditsPopularTest");
		System.out.println(nl);		
		
		List<String> testSegments = new ArrayList<String>();
		
		testSegments.add(RedditApiResourceConstants.SUBREDDITS);
		testSegments.add(RedditApiResourceConstants.POPULAR + RedditApiResourceConstants.DOT_JSON);
		
		RedditRequestInput testInput 
							= new RedditRequestInput(testSegments, 
													 testUserAgent);
		
		final RedditRequestResponse output = RedditRequestor.executeGet(testInput);

		System.out.println(testInput);		
		System.out.println(output);		
		assertEquals(output.getStatus(), 200);
	}	

	public void aboutSubreddit(){
		System.out.println(nl);		
		System.out.println("Begin Method: aboutSubreddit");
		System.out.println(nl);		
		
		List<String> testSegments = new ArrayList<String>();
		
		testSegments.add(RedditApiResourceConstants.R);
		testSegments.add("truerreddit");
		testSegments.add(RedditApiResourceConstants.ABOUT);
		
		RedditRequestInput testInput 
							= new RedditRequestInput(testSegments, 
													 testUserAgent);
		
		final RedditRequestResponse output = RedditRequestor.executeGet(testInput);

		System.out.println(testInput);		
		System.out.println(output);		
		assertEquals(output.getStatus(), 200);
	}	

	public void controversialListings(){
		System.out.println(nl);		
		System.out.println("Begin Method: controversialListings");
		System.out.println(nl);		
		
		List<String> testSegments = new ArrayList<String>();

		testSegments.add(RedditApiResourceConstants.R);
		testSegments.add("funny");		
		testSegments.add(RedditApiResourceConstants.TOP + RedditApiResourceConstants.DOT_JSON);
		
		RedditRequestInput testInput 
							= new RedditRequestInput(testSegments, 
													 testUserAgent);
		
		final RedditRequestResponse output = RedditRequestor.executeGet(testInput);

		System.out.println(testInput);		
		System.out.println(output);		
		assertEquals(output.getStatus(), 200);
	}
	
	public void listComments(){
		System.out.println(nl);		
		System.out.println("Begin Method: listComments");
		System.out.println(nl);		
		
		List<String> testSegments = new ArrayList<String>();

		testSegments.add(RedditApiResourceConstants.R);
		testSegments.add("worldnews");		
		testSegments.add(RedditApiResourceConstants.COMMENTS);
		testSegments.add("1mfj22");
		testSegments.add("japan_shuts_down_last_nuclear_reactor_for_the");
		testSegments.add(RedditApiResourceConstants.DOT_JSON);
		
		RedditRequestInput testInput 
							= new RedditRequestInput(testSegments, 
													 testUserAgent);
		
		final RedditRequestResponse output = RedditRequestor.executeGet(testInput);

		System.out.println(testInput);		
		System.out.println(output);		
		assertEquals(output.getStatus(), 200);
	}

	public void aboutUser(){
		System.out.println(nl);		
		System.out.println("Begin Method: aboutUser");
		System.out.println(nl);		
		
		List<String> testSegments = new ArrayList<String>();

		testSegments.add(RedditApiResourceConstants.USER);
		testSegments.add("JavaJerseyTestBot");		
		testSegments.add(RedditApiResourceConstants.ABOUT);
		
		RedditRequestInput testInput 
							= new RedditRequestInput(testSegments, 
													 testUserAgent);
		
		final RedditRequestResponse output = RedditRequestor.executeGet(testInput);

		System.out.println(testInput);		
		System.out.println(output);		
		assertEquals(output.getStatus(), 200);
	}	
}
