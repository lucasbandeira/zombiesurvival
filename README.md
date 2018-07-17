# zombiesurvival
API REST to survival zombie
http://ec2-18-221-2-247.us-east-2.compute.amazonaws.com:8080/doc/

### GET /survivors
```
Response:
HTTP/1.1 200 OK
  [
	  {
	    "id": 2,
	    "name": "Maria",
	    "age": 30,
	    "gender": "FEMALE",
	    "latitude": "-123696",
	    "longitude": "123686",
	    "delation": 0,
	    "infected": false
	  },
	  {
	    "id": 3,
	    "name": "Mariana",
	    "age": 20,
	    "gender": "FEMALE",
	    "latitude": "-123696",
	    "longitude": "123686",
	    "delation": 0,
	    "infected": false
	  },
	  {
	    "id": 1,
	    "name": "Lucas",
	    "age": 25,
	    "gender": "MALE",
	    "latitude": "-123696",
	    "longitude": "125686",
	    "delation": 0,
	    "infected": false
	  }
	]
```
### GET /survivors/:name
```
Response:
HTTP/1.1 201 OK
    {
      "id": 2,
      "name": "Maria",
      "age": 30,
      "gender": "FEMALE",
      "latitude": "-123696",
      "longitude": "123686",
      "delation": 0,
      "infected": false
    }
```
### POST /survivor
```
Body:
{
  "name": "Maria",
  "age": 30,
  "gender": 0 , //0 female and 1 male
  "latitude": "-123696",
  "longitude": "123686"
}
Response:
HTTP/1.1 201 OK
Survivor added
```
### PUT /survivor/:survivorId
```
Body:
{
  "latitude": "14235325",
  "longitude": "4354543"
}
or
{
  "infected": true
}
Response:
HTTP/1.1 200 OK
Survivor updated
```
