package com.fh.project.algo.graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Description 无向图
 * @Author fenghao
 * @Email 849260688@qq.com
 * @Date 2020/9/13 7:51 上午
 */

public class Graph { // 无向图
    private int v; // 顶点的个数
    private LinkedList<Integer> adj[]; // 邻接表

    public Graph(int v) {
        this.v = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i) {
            adj[i] = new LinkedList<>();
        }
    }

    public void addEdge(int s, int t) { // 无向图一条边存两次
        adj[s].add(t);
        adj[t].add(s);
    }


    public void bfs(int s, int t) {
        if (s == t) return;
        // 用来记录已经被访问过的顶点
        boolean[] visited = new boolean[v];
        visited[s] = true;

        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);

        // 用来记录搜索路径
        int[] prev = new int[v];
        for (int i = 0; i < v; ++i) {
            prev[i] = -1;
        }

        while (queue.size() != 0) {
            int w = queue.poll();
            for (int i = 0; i < adj[w].size(); ++i) {
                int q = adj[w].get(i);
                if (!visited[q]) {
                    prev[q] = w;
                    if (q == t) {
                        print(prev, s, t);
                        return;
                    }
                    visited[q] = true;
                    queue.add(q);
                }
            }
        }
    }

    private void print(int[] prev, int s, int t) { // 递归打印s->t的路径
        if (prev[t] != -1 && t != s) {
            print(prev, s, prev[t]);
        }
        System.out.print(t + " ");
    }


    public static void main(String[] args) {
        boolean flag = true;
        if (flag) System.out.println("Hello, Java!");
        flag = false;
        if (flag == true) System.out.println("Hello, JVM!");
    }
}
