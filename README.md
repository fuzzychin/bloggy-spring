# bloggy-spring
Spring backend for blog

## Milestones
- ~~Use "MappedBy" on all relational annotations (@OneToMany, etc)~~
- ~~Create a GET, POST, PUT, DELETE method for each controller. Look at User/Post for example~~
- Create POSTMAN for each call with Sample data.
    - export collection and add to repo.
- Get Familiar with lookup scenarios for Service methods/endpoints. (i.e. Lookup a post you get the user "author" information as well as comments, tags. You may want to lookup all posts with a particular Author, or All Comments by an Author, etc)
    - i.e created sub contexts relationships ( `/api/user/1/posts` , `/api/user/1/comments`)
- Take a look at Tags and see if current POJO makes sense for a "tagging" system. Look at examples online for ideas
    - http://tagging.pui.ch/post/37027746608/tagsystems-performance-tests
- Look at making validations on the endpoints to ensure data integrity
- Add Title Slugging to the `POST` object.
