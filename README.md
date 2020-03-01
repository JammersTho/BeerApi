#IPA API
Returns beers in JSON format  
The application seeds an H2 in-memory database on startup from data.sql  

##Getting started
Run ./docker-start.sh to build and run the application in a container  
The tomcat wrapper will run the API on port 9091  
Open localhost:9091/beer/ in a browser to test  

##Endpoints
###Get All
Returns all beers
####Example
`9091/beer/`

###Get By ID
Return a beer with the specified ID
#####Example
`9091/beer/23`

###Get By ID
Return a paginated list of beers  
Required request parameters -  
pagesize  
count of results per page - defaults to 5  
page  
zero-based page index - defaults to 0
####Example
`9091/beer/page?pagesize=6&start=1`

###Get Random Beer
Return a random beer  
Takes no parameters
####Example
`9091/beer/random`

###Filter Beers
Returns a list of beers matching a specified string in name or description  
Case insensitive!  
Required request parameter -  
search
####Example
`9091/beer?search=IPA`