def num_islands(grid=[[]]):
    explored = '#'
    land = '1'
    water = '0'
    def explore(i=0, j=0):
        directions = [[1, 0], [-1, 0], [0, 1], [0, -1]]
        queue = [[i, j]]
        grid[i][j] = explored
        while len(queue) > 0:
            [i, j] = queue.pop(0)    
            neighbors = [[i+di, j+dj] for [di, dj] in directions if i+di >= 0 and i+di < len(grid) and j+dj >= 0 and j+dj < len(grid[0])]
            for [x, y] in neighbors:
                if grid[x][y] == land:
                    grid[x][y] = explored
                    queue.append([x, y])
        return
 
    islands = 0
    for i in range(len(grid)):
        for j in range(len(grid[0])):
            if grid[i][j] == land:
                islands += 1
                explore(i, j)
    return islands

def test():
    grid = [
        ['1', '1', '1', '1', '0'],
        ['1', '1', '0', '0', '0'],
        ['1', '1', '0', '1', '1'],
        ['0', '0', '0', '1', '1']
    ]
    return num_islands(grid) == 2

print(test())
