# gerimedica-data-fetcher
Code Assignment

Conditions: 
Use java & spring
Use an in-memory database

Upload data with csv file.


## Upload data
```
HTTP POST
http://localhost:8080/upload

Body:
file: exercise.csv
```

## Get all data
```
HTTP GET
http://localhost:8080/records
```

## Delete all data
```
HTTP DELETE
http://localhost:8080/delete
```
