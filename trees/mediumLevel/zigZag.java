package trees.mediumLevel;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import javax.swing.tree.TreeCellRenderer;

public class zigZag {
      public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>>ansList= new ArrayList<>();

        Queue <TreeNode> q = new LinkedList<>();
           boolean leftToRight = true;
        q.add(root);
        while(q.isEmpty()){
            List<Integer> subList= new ArrayList<Integer>();
            int size = q.size();
            for(int node : subList){
                subList.add(q.offer(n.left));

            }

        }
    }
    }

