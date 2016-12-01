package com.company.day1;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Day1 {

    public static void main(String[] args) {
        MovementStateMachine movementStateMachine = new MovementStateMachine();

        Scanner scanner = new Scanner(args[0]).useDelimiter(", ");
        while (scanner.hasNext()) {
            movementStateMachine.move(scanner.next());
        }
        System.out.println("Total distance: " + movementStateMachine.getTotalDistancePassed());
        System.out.println("First duplicated location is " + movementStateMachine.getDistanceToFirstDuplicatedLocation());
    }

    public static class MovementStateMachine {
        private Position currentPosition = new Position();
        private Orientation orientation = Orientation.NORTH;
        private Set<Position> visitedCoordinates = new HashSet<Position>(){{
            add(currentPosition);
        }};
        private Position firstDuplicatedPosition = null;


        public void move(String nextStep){
            processNextStep(parseStep(nextStep));
        }

        private void processNextStep(Step step){
            orientation = orientation.turn(step.direction);
            if (firstDuplicatedPosition == null)
                walkDiscretely(currentPosition, step.distance);
            else
                walk(currentPosition, step.distance);
        }

        private void walkDiscretely(Position currentPosition, int distance) {
            switch (orientation){
                case NORTH:
                    for (int i = currentPosition.y + 1; i <= currentPosition.y + distance; i++){
                        Position tmpPosition = new Position(currentPosition.x, i);
                        if (!visitedCoordinates.contains(tmpPosition))
                            visitedCoordinates.add(tmpPosition);
                        else
                            firstDuplicatedPosition = tmpPosition;
                    }
                    currentPosition.y += distance;
                    break;
                case EAST:
                    for (int i = currentPosition.x + 1; i <= currentPosition.x + distance; i++){
                        Position tmpPosition = new Position(i, currentPosition.y);
                        if (!visitedCoordinates.contains(tmpPosition))
                            visitedCoordinates.add(tmpPosition);
                        else
                            firstDuplicatedPosition = tmpPosition;
                    }
                    currentPosition.x += distance;
                    break;
                case SOUTH:
                    int ycounter = 0;
                    int tmpY = currentPosition.y;
                    while (ycounter++ < distance){
                        Position tmpPosition = new Position(currentPosition.x, tmpY - ycounter);
                        if (!visitedCoordinates.contains(tmpPosition))
                            visitedCoordinates.add(tmpPosition);
                        else
                            firstDuplicatedPosition = tmpPosition;
                    }
                    currentPosition.y -= distance;
                    break;
                case WEST:
                    int xcounter = 0;
                    int tmpX = currentPosition.x;
                    while (xcounter++ < distance){
                        Position tmpPosition = new Position(tmpX - xcounter, currentPosition.y);
                        if (!visitedCoordinates.contains(tmpPosition))
                            visitedCoordinates.add(tmpPosition);
                        else
                            firstDuplicatedPosition = tmpPosition;
                    }
                    currentPosition.x -= distance;
                    break;
            }
        }

        private void walk(Position currentPosition, int distance) {
            switch (orientation){
                case NORTH:
                    currentPosition.y += distance;
                    break;
                case EAST:
                    currentPosition.x += distance;
                    break;
                case SOUTH:
                    currentPosition.y -= distance;
                    break;
                case WEST:
                    currentPosition.x -= distance;
                    break;
            }
        }

        public int getTotalDistancePassed(){
            return Math.abs(currentPosition.x) + Math.abs(currentPosition.y);
        }

        private Step parseStep(String nextStep){
            Step step = new Step();
            if (nextStep.startsWith("R"))
                step.direction = Direction.RIGHT;
            else if(nextStep.startsWith("L"))
                step.direction = Direction.LEFT;
            step.distance = Integer.parseInt(nextStep.substring(1));
            return step;
        }

        public int getDistanceToFirstDuplicatedLocation() {
            if (firstDuplicatedPosition == null){
                return -1;
            }
            return Math.abs(firstDuplicatedPosition.x) + Math.abs(firstDuplicatedPosition.y);
        }
    }

    private static class Step{
        int distance;
        Direction direction;
    }
}
