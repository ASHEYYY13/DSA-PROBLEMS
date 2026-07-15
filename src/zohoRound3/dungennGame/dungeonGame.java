package zohoRound3.dungennGame;

import java.util.Scanner;

public class dungeonGame {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter the size of the  matrix row and column");
        int row= scanner.nextInt();
        int col=scanner.nextInt();

        char[][] dungeon=new char[row][col];

        for (int i = 0; i <row ; i++) {
            for (int j = 0; j <col ; j++) {
                dungeon[i][j]='.';
            }
        }

        System.out.println("Enter the Adventurer location:");
        int AdRow = scanner.nextInt();
        int AdCol = scanner.nextInt();
        dungeon[AdRow][AdCol]='A';

        System.out.println("Enter the Treasure location:");
        int DesRow = scanner.nextInt();
        int DesCol = scanner.nextInt();
        dungeon[DesRow][DesCol]='X';

        System.out.println("Enter the Trigger:");
        int TrigRow = scanner.nextInt();
        int TrigCol = scanner.nextInt();
        dungeon[TrigRow][TrigCol]='T';
        System.out.println("Enter the Monster location:");
        int MonRow = scanner.nextInt();
        int MonCol = scanner.nextInt();
        dungeon[MonRow][MonCol]='M';

        System.out.println("Enter the Number of Pits:");
        int pits=scanner.nextInt();
        for (int i = 1; i <=pits ; i++) {
            System.out.println("Enter the Trigger :" + i);
            int pitRow = scanner.nextInt();
            int pitCol = scanner.nextInt();
            dungeon[pitRow][pitCol]='P';
        }

        System.out.println("\n Dungeon Layout");

        for (int i = 0; i <row ; i++) {
            for (int j = 0; j <col ; j++) {
                System.out.print(dungeon[i][j] + " ");
            }
            System.out.println();
        }

        int adventurerToTrigger=Math.abs(AdRow-TrigRow)+Math.abs(AdCol-TrigCol);
        int MonsterToTrigger=Math.abs(MonRow-TrigRow)+Math.abs(MonCol-TrigCol);
        int adventurerToTreasure=Math.abs(AdRow-DesRow)+Math.abs(AdCol-DesCol);
        int MonsterToTreasure=Math.abs(MonRow-DesRow)+Math.abs(MonCol-DesCol);

        if(adventurerToTrigger<MonsterToTrigger){
            System.out.println("Ad Reaches Trig first");
            System.out.println("Monster Frozen");
            System.out.println("Ad got the treasure");
        }

        else if(adventurerToTrigger>MonsterToTrigger){
            System.out.println("Mons reaches Trig first");
            System.out.println("trig  deactivates");

            if(adventurerToTreasure<MonsterToTreasure){
                System.out.println("Adventure still reaches Treasure ");
            }
            else {
                System.out.println("Mon catches the Ad");
            }
        }
        else {
            if(adventurerToTreasure<MonsterToTreasure){
                System.out.println("Adventure still reaches Treasure ");
            }
            else {
                System.out.println("Mon catches the Ad");
            }
        }
    }
}
