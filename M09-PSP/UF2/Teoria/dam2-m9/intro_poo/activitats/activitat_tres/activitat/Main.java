package cat.dam.psp.activitat_tres.activitat;

import cat.dam.psp.activitat_tres.activitat.ship.*;

public class Main {

    public static final int MAX_ROUNDS = 2;

    public static void main(String[] args) {
        System.out.println("A long time ago, in a galaxy far, far away...");
        EmpireWarStarship stellarDestructor = EmpireShipFactory.stellarDrestroyer("001-destroyer");
        RepublicStarship xWing = RepublicShipFactory.xWing("001-x-wing");
        System.out.println(stellarDestructor);
        System.out.println(xWing);
        duel(xWing, stellarDestructor, MAX_ROUNDS);
    }


    private static void duel(WarStarship attacker, WarStarship target, int rounds) {
        System.out.printf("WARNING: %s is attacking %s\n", attacker.getId(), target.getId());
        System.out.println("Initial battle status");
        System.out.println("<********     ********>");
        printBattleLog(attacker);
        printBattleLog(target);
        WarStarship winner = doTurn(attacker, target, rounds);
        while (!winner.isDestroyed()) {
            System.out.println("\n<******** NEXT TURN ********>\n");
            winner = doTurn(target, attacker, rounds);
        }
    }

    private static WarStarship doTurn(WarStarship attacker, WarStarship target, int rounds) {
        int i = 0;
        boolean continueBattle = true;
        while (i < rounds && continueBattle) {
            System.out.printf("\n%s <-|-> %s --> ROUND %d ... --> FIGHT !!! <--\n", attacker.getFaction(), target.getFaction(), i + 1);
            if (target.defendAgainst(attacker)) {
                printBattleLog(attacker);
                printBattleLog(target);
            } else {
                System.out.printf("\t%s is Destroyed", target.getId());
                continueBattle = false;
            }
            i++;
        }
        return (target.isDestroyed()) ? target : attacker;
    }

    private static void printBattleLog(WarStarship ship) {
        System.out.printf("\t%s [%.2f] - ((%.2f))\n", ship.getId(), ship.getHullIntegrity(), ship.getShields());
    }
}