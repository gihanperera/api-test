# api-test
# get postman collection below mentioned path
postman collection/assign-api.postman_collection.json
# Please use postgress database and restore below mentioend db bump
  postgre sql database dumb/dump_assign_db.sql
# Databasename - backend
# Please add record to empuser table to login,If unable to restore dump 
  user_name - gihan , 
  pass_word - gihan@123
# Login url - localhost:8083/users/verify
  username - gihan ,
  password - gihan@123
# when api service using please add header to 
  authToken - sample
