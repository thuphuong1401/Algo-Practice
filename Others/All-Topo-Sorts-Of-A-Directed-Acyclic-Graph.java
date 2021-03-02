/*
https://www.geeksforgeeks.org/all-topological-sorts-of-a-directed-acyclic-graph/

Print ALL topological sorted order of a directed acyclic graph
*/

Method used: backtracking

Pseudocode goes something like this: 

    allTopoSort() {
        calculate array of indegree
        call util();
    }
    
    
    util() {    
        for(vertex v) {
            if(!visited[v] && indegree[v] == 0) {
                visited[v] = true;
                queue.add(v);
                reduce degree of adjacent vertices. 
                util();
                visited[v] = false;
                add back degree of adjacent vertices
                queue.remove();
            }
        }
    
        print queue
    }
