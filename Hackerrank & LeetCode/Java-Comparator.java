/*
https://www.hackerrank.com/challenges/java-comparator/problem
*/

/*
Short version
*/
class Checker implements Comparator<Player>{
    @Override
    public int compare(Player a, Player b){
        if (a.score == b.score){
            return a.name.compareTo(b.name);//alphabetically
        } else {
            return b.score - a.score;//decreasing 
        }
    }
}


/*
Long version
*/
class Checker implements Comparator<Player> {
    
    public int compare(Player p1, Player p2) {
        if(p1.score != p2.score) {
            if(p1.score < p2.score) {
                return 1;
            } 
            return -1;
        } else {
            if(p1.name != p2.name) {
                return p1.name.compareTo(p2.name);
            }
            return 0;
        }
    }
}
