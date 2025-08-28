class Solution {
    public int[][] sortMatrix(int[][] grid) {
        int n=grid.length;
        for(int r=0;r<n;r++){
            sortDiagonal(grid,r,0,true);
        }
        for(int c=1;c<n;c++){
            sortDiagonal(grid,0,c,false);
        }
        return grid;
    }
    private void sortDiagonal(int[][] g,int r,int c,boolean nonIncreasing) {
        int n=g.length;
        List<Integer> vals = new ArrayList<>();
        int i=r,j=c;
        while(i<n && j<n) {
            vals.add(g[i][j]);
            i++;j++;
        }
        if(nonIncreasing){
            vals.sort(Collections.reverseOrder());
        }
        else{
            Collections.sort(vals);
        }
        i=r;j=c;
        int idx=0;
        while(i<n && j<n){
            g[i][j] = vals.get(idx++);
            i++;j++;
        }
    }   
}