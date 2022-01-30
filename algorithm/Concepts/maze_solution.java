/*
Robot in a Grid: Imagine a robot sitting on the upper left corner of grid with r rows and c columns.
The robot can only move in two directions, right and down, but certain cells are "off limits" such that
the robot cannot step on them. Design an algorithm to find a path for the robot from the top left to the bottom right. 
 */

import java.io.*;
import java.util.*;

class Pointer {
  public int x;
  public int y;
  public int value;
  public Pointer(int x, int y) {
    this.x = x;
    this.y = y;
  }
  public void printPoint() {
    System.out.println("(" + this.x + ", " + this.y + ")");
  }
}

class Solution {
  public static void main(String[] args) {
    int[][] matric = {
      { 0, 0, 0, 0, 0, 0 },
      { 0, 1, 0, 1, 0, 0 },
      { 1, 0, 0, 1, 1, 1 },
      { 1, 1, 0, 0, 0, 0 },
    };
    ArrayList<Pointer> path = new ArrayList<Pointer>();
    HashSet<Pointer> vistedPoint = new HashSet<Pointer>();
    findPath(matric, new Pointer(0, 0), path, vistedPoint);
    for (Pointer po : path) {
      po.printPoint();
    }
  }
  
  public static boolean findPath(int[][] matric, Pointer point, ArrayList<Pointer> path, HashSet<Pointer> vistedPoint) {
    if (point.x > matric.length - 1 || point.y > matric[0].length - 1 || matric[point.x][point.y] == 1) {
      return false;
    }
    
    if (vistedPoint.contains(point)) {
      return false;
    }
    
    boolean endOfMaze = point.x == matric.length - 1 && point.y == matric[0].length - 1;
    Pointer rightpointer = new Pointer(point.x, point.y + 1);
    Pointer downpointer = new Pointer(point.x + 1, point.y);
    if (endOfMaze || findPath(matric, rightpointer, path, vistedPoint) || findPath(matric, downpointer, path, vistedPoint)) {
      path.add(point);
      return true;
    }
    vistedPoint.add(point);
    return false;
  }
}
