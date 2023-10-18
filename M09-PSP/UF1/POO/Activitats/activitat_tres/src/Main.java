package daniel.Cabrera;

import daniel.Cabrera.ship.*;

public class Main {
    private static final int MAX_ROUNDS = 5; // Definir el número máximo de rondas

    public static void main(String[]args){
        System.out.println("A long time ago, in a galaxy far, far away...");
        EmpireWarStarship stellarDestructor=EmpireShipFactory.stellarDrestroyer("001-destroyer");
        RepublicStarship xWing=RepublicShipFactory.xWing("001-x-wing");
        System.out.println(stellarDestructor);
        System.out.println(xWing);
        duel(xWing,stellarDestructor,MAX_ROUNDS);
    }


    private static void duel(WarStarship attacker, WarStarship target, int rounds) {
        for (int round = 1; round <= rounds; round++) {
            if (attacker.isDestroyed() || target.isDestroyed()) {
                break;
            }

            attacker = doTurn(attacker, target, round);
            WarStarship temp = attacker;
            attacker = target;
            target = temp;
        }

        if (attacker.isDestroyed()) {
            printBattleLog(target);
        } else {
            printBattleLog(attacker);
        }
    }

    private static WarStarship doTurn(WarStarship attacker, WarStarship target, int round) {
        return attacker; // Devuelve la nave actualizada
    }

    private static void printBattleLog(WarStarship ship) {

    }
}
