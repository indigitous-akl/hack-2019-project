// Begin Transaction
tx = graph.newTransaction();

// Vertices
indigitous_user_bramford_horton = tx.addVertex(label, "indigitous_user", "id", "3012", "name", "Bramford Horton", "email", "bram.horton@gmail.com")
indigitous_user_winston_poh = tx.addVertex(label, "indigitous_user", "id", "5015", "name", "Winston Poh", "email", "winst940116@hotmail.my")
github_user_bramford_horton = tx.addVertex(label, "github_user", "username", "bramford", "name", "Bramford Horton", "email", "bram.horton@gmail.com")
github_user_winston_poh = tx.addVertex(label, "github_user", "username", "winstonpoh", "name", "Winston Poh", "email", "winst940116@hotmail.my")

// Edges
indigitous_user_bramford_horton.addEdge("is", github_user_bramford_horton)
indigitous_user_winston_poh.addEdge("is", github_user_winston_poh)

// Commit data
tx.commit()
