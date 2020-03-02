#IPA API  
Returns beers in JSON format  
The application seeds an H2 in-memory database on startup from data.sql and returns beers in the following format  
`{"id":1,"name":"Buzz","tagline":"A Real Bitter Experience.","first_brewed":"09/2007","description":"A light\\, crisp and bitter IPA brewed with English and American hops. A small batch brewed only once.","image_url":"https://images.punkapi.com/v2/keg.png","abv":4.5}`  

##Getting started  
Run `./docker-start.sh` to build and run the application in a container  
The tomcat wrapper will run the API on port 9091  
Open <localhost:9091/beer/> in a browser to test  

##Endpoints  
###Get All  
Returns all beers  
####Example  
`9091/beer/`  

###Get By ID  
Return a beer with the specified ID  
#####Example  
`9091/beer/23`  

###Get Page  
Return a paginated list of beers  
Required request parameters -  
start  
zero-based page index - defaults to 0  
pagesize  
count of results per page - defaults to 5  
####Example  
`9091/beer/page?start=6&pagesize=1`  

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
`9091/beer/filter?search=IPA`
