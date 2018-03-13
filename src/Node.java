import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by student on 10/28/2017.
 */
public class Node {
    M_and_C states;
    Node Parent;
    int Depth;

    public Node(M_and_C state, Node parent, int depth) {
        this.states = state;
        Parent = parent;
        Depth = depth;
    }

    public  static Node BFS(M_and_C init){
        Node root = new Node(init,null,0);

        Queue<Node> Fringe = new LinkedList<>();

        Fringe.add(root);

        while(!Fringe.isEmpty()){
            Node n = Fringe.poll();
            M_and_C Snode = n.states;
            if(Snode.isGoalState()){
                return n;
            }
            ArrayList<M_and_C>  Success = Snode.ApplyAction();

            for(M_and_C s : Success){
                Node node = new Node(s,n,n.Depth+1);
                Fringe.add(node);

            }
        }
        return null;
    }

    public  static Node DFS(M_and_C init){
        Node root = new Node(init,null,0);
        ArrayList<M_and_C> visited = new ArrayList<>();
        Stack<Node> Fringe = new Stack<>();

        Fringe.push(root);
        while(!Fringe.isEmpty()){
            Node n = Fringe.pop();
            M_and_C Snode = n.states;
            visited.add(Snode);
            if(Snode.isGoalState()){
                return n;
            }
            ArrayList<M_and_C>  Success = Snode.ApplyAction();
            for(M_and_C s : Success){
                boolean visit = true;
                for(M_and_C v : visited) {
                    if(s.ml == v.ml && s.cl == v.cl && s.mr == v.mr && s.cr == v.cr && s.b.equals(v.b)) {
                        visit = false;
                        break;
                    }
                }
                if(visit) {
                    Node node = new Node(s, n, n.Depth + 1);
                    Fringe.push(node);
                }
            }
        }
        return null;
    }



    public static  void printSolution(Node n){
        Stack<M_and_C> List = new Stack<>();

        while(n != null){
            List.add(n.states);
            n = n.Parent;
        }
        while (!List.isEmpty()){
            System.out.println(List.pop());
        }

    }
}
