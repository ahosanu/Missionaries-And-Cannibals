public class Main {

    public static void main(String[] args) {
        M_and_C init = new M_and_C(3, 3, 0, 0, "LEFT");
        Node Goal = Node.DFS(init);
        System.out.println("Depth -> "+ Goal.Depth);
        Node.printSolution(Goal);
    }
}
