package datastructures;

public class TowerOfHanoi {

    private void towerOfHanoi(int n, String from, String to, String aux) {
        if(n == 1) {
            System.out.println("Move Disk " + n + " from " + from + " to " + to);
            return;
        }
        towerOfHanoi(n-1, from, aux, to);
        System.out.println("Move Disk " + n + " from " + from + " to " + to);
        towerOfHanoi(n-1, aux, to, from);
    }

    public static void main(String[] args) {
        TowerOfHanoi towerOfHanoi = new TowerOfHanoi();
        towerOfHanoi.towerOfHanoi(2, "A", "C", "B");
    }
}
