# ScarletHack2017
The repository used for the group in ScarletHacks 2017. Team members are Tomas, Pradeep, Zaid and David

# Backstory
When we were brainstorming on what to do for an app we thought about the issues that affect people on a daily basis. We all concluded that one of the main issues facing the population is the disconnect between the elected officials that make key decisions that affect everyday people. So we set out to find a way to connect people with their elected officials.

# What our app does
To reduce that disconnect, we agreed that giving the person access to the contact information about their local elected official. To do this we require the user to enter a zip code. Upon entering a zip code we go through a database and return all the contact information of the Senators, representative and governor relative to the zip code entered. The beauty of the app is that it’s targeted for anyone, and its designed to be easy to use as well. We also incorporated ad-based monetization by displaying ads in the bottom of the screen which should be able to earn us some revenue over time as people use it.

# Sample of our code
```/**
	 * Code to get Senator #1 from state.
	 * @return Array with all information relating to Senator #1 from Zip Code.
	 */
	public String[] getSentateNum1() {
                //Creates an ArrayList.
		ArrayList<String> output = new ArrayList<String>();

                //Goes through the entire array of JSON Data and picks out anything relating to Senator #1
		for (int i = 0; i < JSONarr.length; i++) {
			if (JSONarr[i].contains("national_senator_1")) {
				String temp = JSONarr[i];
				temp = temp.substring(temp.indexOf(" ", 19), temp.length() - 2);
				temp = temp.substring(2, temp.length());
				output.add(temp);
			}
		}

                //Converts Arraylist to an Array
		String[] stockArr = new String[output.size()];
		stockArr = output.toArray(stockArr);

		return stockArr;
	}
```
