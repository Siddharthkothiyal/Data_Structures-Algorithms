import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class keysrooms {
     public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean vis[] = new boolean[rooms.size()];
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        vis[0] = true;

        while (!q.isEmpty()) {

            int room = q.poll();

            for (int key : rooms.get(room)) {
                if (!vis[key]) {
                    vis[key] = true;
                    q.add(key);
                }
            }
        }
            for (boolean check : vis) {

                if (check == false)
                    return false;
            }

        

        return true;

    }
}
