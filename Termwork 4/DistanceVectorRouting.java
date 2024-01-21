    import java.util.Scanner;


    public class DistanceVectorRouting{

        void calculateroutingtable(int n , int distance[][])
        {
            int i, j, k;
            int routingtable[][] = new int[n][n];

            for(i =0 ;i<n; i++){
                for(j =0; j<n ; j++)
                {
                    routingtable[i][j] =j;
                }
            }

            // Floyd -Warshall Algorithm

            for (k = 0; k < n; k++) {
                for (i = 0; i < n; i++) {
                    for (j = 0; j < n; j++) {
                        if (distance[i][j] > distance[i][k] + distance[k][j]) {
                            distance[i][j] = distance[i][k] + distance[k][j];
                            routingtable[i][j] = k; 
                        }
                    }
                }
            }

            System.out.println("Routing Table: ");
            for(i=0 ; i<n ;i++){
                System.out.println("For node "+ i);
                System.out.println("To cost next hop ");

                for(j=0 ; j<n ;j++){
                    if(i!=j){
                        System.out.println(j + "" + distance[i][j]+ ""+ routingtable[i][j]);
                    }
                }
            }
        }
        public static void main(String[] args) {

            int n , i  , j;
            System.out.println("Entered the number of nodes ");
            Scanner sc = new Scanner(System.in);
            n = sc.nextInt();

            if (n <=0 || n >=10){
                System.out.println("Invalid number of codes");
                return ;
            }

            int distance[][] = new int[n][n];

            System.out.println("Enter the distance matrix:");

            for(i = 0;i<n ; i++)
            {
                for(j=0;j<n;j++)
                {   
                    distance[i][j]= sc.nextInt();
                    if (i==j){
                    distance[i][j] = 0;
                }
                    else if (distance[i][j] <0)
                    {
                    System.out.println("Invalid distance: \n");
                    return ; 
                    }
                }
            }

            new DistanceVectorRouting().calculateroutingtable(n , distance);
            
        }
        
    }