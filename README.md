# Puzzles-IslandPerimeter

Find the perimeter of the one island.

## Lesson Task Description

Here are the instructions from the video.

This is a classic Apple interview question.

The input to the problem is an m by n binary grid.

All of the water is represented by zeros.

All of the land is represented by ones.

This looks like it is going to be a graph problem.

However, this problem is much easier.

We are guaranteed that there will be exactly one island.

The goal is to sum up the entire perimeter of the island.

The sample m by n binary grid expects an answer of 16.

Each square on the grid has 4 edges.

Since this is not a graph problem, we do not need to implement DFS or BFS.

We iterate over every position in the grid, O(m * n).

We analyze every position with a value of 1.

Each position would add 4 to the perimeter.

However, 1 must be subtracted every time an edge has a connected 1.

That is not a perimeter edge.


```

 m 0 1 0 0
 m 1 1 1 0
 m 0 1 0 0
 m 1 1 0 0
   n n n n

```
