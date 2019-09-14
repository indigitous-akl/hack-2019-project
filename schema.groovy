// Start graph management
mgmt = graph.openManagement()

/*
Property Key types
*/
name = mgmt.makePropertyKey("name").dataType(String.class).make()
uid = mgmt.makePropertyKey("uid").dataType(String.class).make()
email = mgmt.makePropertyKey("email").dataType(String.class).make()
login = mgmt.makePropertyKey("login").dataType(String.class).make()

/*
Edge labels
*/
mgmt.makeEdgeLabel("is").multiplicity(Multiplicity.SIMPLE).make()
mgmt.makeEdgeLabel("owns").multiplicity(Multiplicity.ONE2MANY).make()

/*
Vertex labels
*/
repo = mgmt.makeVertexLabel("indigitous_user").make()
repo = mgmt.makeVertexLabel("github_user").make()

// Commit the schema
mgmt.commit()
