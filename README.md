# Project - Indigitous Member & Github User Correlations

## Overview

Our goal in this project is to find data correlations between Indigitous Members using data found on their Github profile(s). Github has a wealth of data and is the largest public network of developers in the world. We're hoping to use this data to find valuable relationships between Indigitous members who have Github profiles. Some correlations we're hoping we'll make:

* Indigitous members and their associated Github profile.
* Programming languages shared between Indigitous members.
* Projects/repositories shared between Indigitous members.
* Forks shared between indigitous members
* Collaborators shared between Indigitous members.

To do this, we'll be building a Graph of Indigitous users then enriching it with useful data we find from Github's API.

The technologies we'll use along the way are:

* Indigitous REST API
* Github API V4 (GraphQL)
* JanusGraph OLTP graph database
* Apache Tinkerpop3 Gremlin (graph traversal query language)
* Any language of your choice that supports all of the above. Supported options are:
  - Java
  - Groovy
  - C#
  - Python
  - Javascript

_Never heard of Graphs, GraphDBs, Gremlin, GraphQL or REST?_

No worries - We'll have experts on-site and we'll be running tutorials/intros at the beginning of the weekend to ensure everyone can help/contribute. It will help immensely if you're well prepared -- see below.

_What do I need to bring?_

* Yourself
* Your computer, hopefully a laptop, running GNU/Linux, Mac OSX or Windows 10.

_How should I prepare?_

* Ensure your laptop and all installed packages/tools are up-to-date.
* Install docker and docker-compose. Get familiar with them through the official tutorial(s).
* Read up on graphs, graph databases and Gremlin. Ideally follow the JanusGraph getting started tutorial.
* Read up on GraphQL, Github's v4 GraphQL API. Ideally have a play with Github's v4 GraphQL API through the explorer.
* Read up on REST APIs. Ideally have a play with a popular public REST API (e.g. Github v3 API).

## Tasks

### Design Schema
1. Map out possible vertices, edges and properties
2. Draw dot diagram

### Search & Store Indigitous users
1. Authenticate to Indigitous API (use indigitous-api-example, will need client key, secret from Bram)
2. Search/get all pages of Indigitous users
  - Example search query: https://indigitous.org/wp-json/wp/v2/users/?search=david@dkjensen.com
  - Follow instructions here: https://developer.wordpress.org/rest-api/using-the-rest-api/pagination/
3. Design schema
4. Add all Indigitous users as vertices with each valid property
  - name
  - location
  - email
  - description
  - etc

### Search Github users for Indigitous users
1. Determine the best way to search users
  - Name?
  - Email?
2. Write Github GraphQL search query, breaking it into chunks to work around cursor/page limit of 10x 100.
3. Write Indigitous user search query (for matching github with stored indigitous users)
4. Design schema
5. Run search and buffer (e.g. just store) found users in graph with some edge to indigitous user
6. Have a human manually verify each potential match then add an edge to confirm match

### User Projects
1. Write a GraphQL query to get all projects under a user, including:
  - Name
  - Primary language
  - All contributors (i.e. their github profiles)
2. Design schema and query for storing #1
3. Run queries and store data

### Common Languages
1. Write query to search for users who contribute to projects in the same language
2. Edge indigitous users (through their github profile) that share languages

### Common Projects
1. Write query to search for users who contribute to the same project(s)
2. Edge indigitous users (through their github profile) to other users who collaborate on said project

### Shared Collaborators
1. Write query to search for all contributors a user collaborates with. This should be correlated against the same query for other users.
2. Edge indigitous users (through their github profile) to other indigitous users that have shared collaborations

### Common Forks

1. Write GraphQL query to get all forks for a github user
2. Get all forks for all Indigitous Github users
3. Design schema and query for storing #2
4. Store #2

### Description Mining

Look for valuable information in each user's description. For example:
* Github links
* Project/website links
* Role title
* Company name
* Anything else of value

Build up a dataset of this with edges and vertices.

### Web UI

Build a WebUI that can display some of the valuable data we've collected. For example:

1. List (and yes/no verify) github profiles that might match Indigitous users (useful for "Search Github users for Indigitous users" #6)
2. List indigitous users who have a Github profile
3. For a given user, show:
  - All Indigitous github collaborators, with the projects on which the user collaborated
  - All shared collaborators with other Indigitous github users, with the names of shared collaborators and projects on which collaboration occurred
  - All forks shared with other indigitous users
  - Number of Indigitous users per language (maybe sorted by number of projects per user in a particular language)

#### Bonus Features
- Authentication (maybe using Indigitous credentials)
- Backend service so that the UI doesn't connect directly to the graph DB
