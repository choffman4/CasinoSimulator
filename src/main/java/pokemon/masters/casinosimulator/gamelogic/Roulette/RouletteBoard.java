package pokemon.masters.casinosimulator.gamelogic.Roulette;

import java.util.Random;

public class RouletteBoard {
    Random random = new Random();
    public final Cell[] cells = new Cell[36];
    public final Cell[] specialCells = new Cell[13];


    private int chipValueInHand;


    public RouletteBoard() {

        String color;
        boolean isEven = false;
        int cellId = 3;
        //Starts counting at 3

        for (int col = 0; col < 12; col++) {
            for (int row = 2; row >= 0; row--) {
                color = spinColor(cellId);
                Cell cell = new Cell(color, cellId, 36);
                cell.setCellRow(row);
                cell.setCellColumn(col);

                cell.setEven(cellId % 2 == 0);

                if(row == 1 && col > 0 && col < 11) {
                    cell.setTopCellNumber(cellId + 1);
                    cell.setRightCellNumber(cellId + 3);
                    cell.setLeftCellNumber(cellId - 3);
                    cell.setBottomCellNumber(cellId - 1);
                } else if(row == 0 && col == 0) {
                    cell.setTopCellNumber(cellId + 1);
                    cell.setRightCellNumber(cellId + 3);
                    cell.setLeftCellNumber(0);
                    cell.setBottomCellNumber(0);
                } else if(row == 1 && col == 0){
                    cell.setTopCellNumber(cellId + 1);
                    cell.setRightCellNumber(cellId + 3);
                    cell.setLeftCellNumber(0);
                    cell.setBottomCellNumber(cellId - 1);
                } else if(row == 2 && col == 0) {
                    cell.setTopCellNumber(0);
                    cell.setRightCellNumber(cellId + 3);
                    cell.setLeftCellNumber(0);
                    cell.setBottomCellNumber(cellId - 1);
                }

                else if(row == 0 && col == 11) {
                    cell.setTopCellNumber(cellId + 1);
                    cell.setRightCellNumber(0);
                    cell.setLeftCellNumber(cellId - 3);
                    cell.setBottomCellNumber(0);
                } else if(row == 1 && col == 11) {
                    cell.setTopCellNumber(0);
                    cell.setRightCellNumber(cellId + 3);
                    cell.setLeftCellNumber(0);
                    cell.setBottomCellNumber(cellId - 1);
                } else if(row == 2 && col == 11) {
                    cell.setTopCellNumber(0);
                    cell.setRightCellNumber(0);
                    cell.setLeftCellNumber(cellId - 3);
                    cell.setBottomCellNumber(cellId - 1);
                }

                cells[cellId-1] = cell;
                System.out.println("cell[].getCellId == " + cellId + " | cell[" + (cellId - 1) + "]");
                cellId--;
            }
            cellId += 6;
        }

        Cell cell0 = new Cell(0, 35, "cell0");
        specialCells[0] = cell0;
        Cell cell1to18 = new Cell(1, 1, "cell1to18");
        specialCells[1] = cell1to18;
        Cell cell19to36 = new Cell(2, 1, "cell19to36");
        specialCells[2] = cell19to36;
        Cell cellRed = new Cell(3, 1, "cellRed");
        specialCells[3] = cellRed;
        Cell cellBlack = new Cell(4, 1, "cellBlack");
        specialCells[4] = cellBlack;
        Cell cellOdd = new Cell(5, 1, "cellOdd");
        specialCells[5] = cellOdd;
        Cell cellEven = new Cell(6, 1, "cellEven");
        specialCells[6] = cellEven;
        Cell cell1st12 = new Cell(7, 1, "cell1st12");
        specialCells[7] = cell1st12;
        Cell cell2nd12 = new Cell(8, 1, "cell2nd12");
        specialCells[8] = cell2nd12;
        Cell cell3rd12 = new Cell(9, 1, "cell3rd12");
        specialCells[9] = cell3rd12;
        Cell cellRow2= new Cell(10, 1, "cellRow2");
        specialCells[10] = cellRow2;
        Cell cellRow1 = new Cell(11, 1, "cellRow1");
        specialCells[11] = cellRow1;
        Cell cellRow0 = new Cell(12, 1, "cellRow0");
        specialCells[12] = cellRow0;
    }

    public SpinResult SpinWheel() {
        int spinNumber = random.nextInt(37);
        //int spinNumber = 2;
        String color = spinColor(spinNumber);
        SpinResult spin = new SpinResult(color, spinNumber);
        if (spinNumber != 0) {
            int column = checkColumn(spinNumber);
            int row = checkRow(spinNumber);
            boolean isHalf = checkHalf(spinNumber);
            spin.setColumn(column);
            spin.setRow(row);
            spin.setFirstHalf(isHalf);
            if (spinNumber % 2 == 0) {  //EVEN
                spin.setEven(true);
            } else { //ODD
                spin.setEven(false);
            }
        }
        return spin;
    }

    private String spinColor(int spinNumber) {
        String color = null;
        if (spinNumber == 0) {
            color = "green";
        }
        else if(spinNumber == 1 || spinNumber == 3 || spinNumber == 5 || spinNumber == 7 || spinNumber == 9
                || spinNumber == 12 || spinNumber == 14 || spinNumber == 16 || spinNumber == 18
                || spinNumber == 19 || spinNumber == 21 || spinNumber == 23 || spinNumber == 25
                || spinNumber == 27 || spinNumber == 30 || spinNumber == 32 || spinNumber == 34
                || spinNumber == 36) {
            color = "red";
        } else {
            color = "black";
        }
        return color;
    }

    private int checkRow(int spinNumber) {
        int row = 7;
        if (spinNumber == 1 || spinNumber == 4 || spinNumber == 7 || spinNumber == 10 || spinNumber == 13 || spinNumber == 16 || spinNumber == 19 || spinNumber == 22
                || spinNumber == 25 || spinNumber == 28 || spinNumber == 31 || spinNumber == 34) {
            row = 0;
        } else if (spinNumber == 2 || spinNumber == 5 || spinNumber == 8 || spinNumber == 11 || spinNumber == 14 || spinNumber == 17 || spinNumber == 20
                || spinNumber == 23 || spinNumber == 26 || spinNumber == 29 || spinNumber == 32 || spinNumber == 35) {
            row = 1;
        } else if (spinNumber == 3 || spinNumber == 6 || spinNumber == 9 || spinNumber == 12 || spinNumber == 15 || spinNumber == 18 || spinNumber == 21
                || spinNumber == 24 || spinNumber == 27 || spinNumber == 30 || spinNumber == 33 || spinNumber == 36) {
            row = 2;
        }
        return row;
    }

    private int checkColumn(int spinNumber) {
        int col = 7;
        if(spinNumber == 1 || spinNumber == 2 || spinNumber == 3 || spinNumber == 4 || spinNumber == 5
                || spinNumber == 6 || spinNumber == 7 || spinNumber == 8 || spinNumber == 9 || spinNumber == 10
                || spinNumber == 11 || spinNumber == 12) {
            col = 0;
        } else if (spinNumber == 13 || spinNumber == 14 || spinNumber == 15 || spinNumber == 16 || spinNumber == 17
                || spinNumber == 18 || spinNumber == 19 || spinNumber == 20 || spinNumber == 21 || spinNumber == 22
                || spinNumber == 23 || spinNumber == 24) {
            col = 1;
        } else if (spinNumber == 25 || spinNumber == 26 || spinNumber == 27 || spinNumber == 28 || spinNumber == 29
                || spinNumber == 30 || spinNumber == 31 || spinNumber == 32 || spinNumber == 33 || spinNumber == 34
                || spinNumber == 35 || spinNumber == 36) {
            col = 2;
        }
        return col;
    }

    private boolean checkHalf(int spinNumber) {
        boolean isFirstHalf;
        if(spinNumber >= 1 && spinNumber <= 18) {
            isFirstHalf = true;
        } else {
            isFirstHalf = false;
        }
        return isFirstHalf;
    }

    public int getChipValueInHand() {
        return chipValueInHand;
    }

    public void setChipValueInHand(int chipValueInHand) {
        System.out.println("Selected Chip: " + chipValueInHand);
        this.chipValueInHand = chipValueInHand;
    }

    public int checkWinnerPayout(SpinResult spin) {
        int payoutMultiplier = 0;
        int chipsValue = 0;
        if(spin.getNumber() == 0 && specialCells[0].isHasChip()) {
            chipsValue += specialCells[0].getChipValue();
            payoutMultiplier = 36;
        }
        ////Special Win conditions
        if(spin.isEven() && specialCells[6].isHasChip()) {
            chipsValue += specialCells[6].getChipValue();
            payoutMultiplier = specialCells[6].getPayOut();
        }
        if(spin.isEven() == false && specialCells[5].isHasChip()) {
            chipsValue += specialCells[5].getChipValue();
            payoutMultiplier = specialCells[5].getPayOut();
        }
        if(spin.getColor().equals("red") && specialCells[3].isHasChip()) {
            chipsValue += specialCells[3].getChipValue();
            payoutMultiplier = specialCells[3].getPayOut();
        }
        if(spin.getColor().equals("black") && specialCells[4].isHasChip()) {
            chipsValue += specialCells[4].getChipValue();
            payoutMultiplier = specialCells[4].getPayOut();
        }
        if(spin.isFirstHalf() && specialCells[1].isHasChip()) {
            chipsValue += specialCells[1].getChipValue();
            payoutMultiplier = specialCells[1].getPayOut();
        }
        if(spin.isFirstHalf() == false && specialCells[2].isHasChip()) {
            chipsValue += specialCells[2].getChipValue();
            payoutMultiplier = specialCells[2].getPayOut();
        }
        if(spin.getColumn() <= 3 && spin.getColumn() >= 0 && specialCells[7].isHasChip()) {
            chipsValue += specialCells[7].getChipValue();
            payoutMultiplier = specialCells[7].getPayOut();
        }
        if(spin.getColumn() <= 7 && spin.getColumn() >= 4 && specialCells[8].isHasChip()) {
            chipsValue += specialCells[8].getChipValue();
            payoutMultiplier = specialCells[8].getPayOut();
        }
        if(spin.getColumn() <= 11 && spin.getColumn() >= 8 && specialCells[9].isHasChip()) {
            chipsValue += specialCells[9].getChipValue();
            payoutMultiplier = specialCells[9].getPayOut();
        }
        if(spin.getRow() == 0 && specialCells[12].isHasChip()) {
            chipsValue += specialCells[12].getChipValue();
            payoutMultiplier = specialCells[12].getPayOut();
        }
        if(spin.getRow() == 1 && specialCells[11].isHasChip()) {
            chipsValue += specialCells[11].getChipValue();
            payoutMultiplier = specialCells[11].getPayOut();
        }
        if(spin.getRow() == 2 && specialCells[10].isHasChip()) {
            chipsValue += specialCells[10].getChipValue();
            payoutMultiplier = specialCells[10].getPayOut();
        }

        if(spin.getNumber() != 0 && cells[spin.getNumber() - 1].isHasChip()) {
            for (Cell cell : cells) {
                if(cell.getCellId() == spin.getNumber()) {
                    if(cell.isHasChip()) {


                        payoutMultiplier = 36;
                        //Check Left Cell
                        if(cell.getLeftCellNumber() != 0 && cells[cell.getLeftCellNumber() - 1].isHasChip()) {
                            chipsValue = 0;
                            chipsValue += cell.getChipValue();
                            chipsValue += cells[cell.getLeftCellNumber() - 1].getChipValue();
                            payoutMultiplier = 17;
                        }
                        if(cell.getRightCellNumber() != 0 && cells[cell.getRightCellNumber() - 1].isHasChip()) {
                            chipsValue = 0;
                            chipsValue += cell.getChipValue();
                            chipsValue += cells[cell.getRightCellNumber() - 1].getChipValue();
                            payoutMultiplier = 17;
                        }
                        if(cell.getTopCellNumber() != 0 && cells[cell.getTopCellNumber() - 1].isHasChip()) {
                            chipsValue = 0;
                            chipsValue += cell.getChipValue();
                            chipsValue += cells[cell.getTopCellNumber() - 1].getChipValue();
                            payoutMultiplier = 17;
                        }
                        if(cell.getBottomCellNumber() != 0 && cells[cell.getBottomCellNumber() - 1].isHasChip()) {
                            chipsValue = 0;
                            chipsValue += cell.getChipValue();
                            chipsValue += cells[cell.getBottomCellNumber() - 1].getChipValue();
                            payoutMultiplier = 17;
                        }

                        if(cell.getTopCellNumber() != 0) {
                            if(cell.getLeftCellNumber() != 0 && cells[cell.getTopCellNumber() - 1].isHasChip()
                                    && cells[cell.getLeftCellNumber() - 1].isHasChip()
                                    && cells[cell.getLeftCellNumber()].isHasChip()) {
                                chipsValue = 0;
                                chipsValue += cell.getChipValue();
                                chipsValue += cells[cell.getBottomCellNumber() - 1].getChipValue();
                                chipsValue += cells[cell.getBottomCellNumber()].getChipValue();
                                chipsValue += cells[cell.getTopCellNumber() - 1].getChipValue();
                                payoutMultiplier = 8;
                            }
                            if(cell.getRightCellNumber() != 0 && cells[cell.getTopCellNumber() - 1].isHasChip()
                                    && cells[cell.getRightCellNumber() - 1].isHasChip()
                                    && cells[cell.getRightCellNumber()].isHasChip()) {
                                chipsValue = 0;
                                chipsValue += cell.getChipValue();
                                chipsValue += cells[cell.getRightCellNumber() - 1].getChipValue();
                                chipsValue += cells[cell.getRightCellNumber()].getChipValue();
                                chipsValue += cells[cell.getTopCellNumber() - 1].getChipValue();
                                payoutMultiplier = 8;
                            }
                        }
                        if(cell.getBottomCellNumber() != 0) {
                            if(cell.getLeftCellNumber() != 0 && cells[cell.getBottomCellNumber() - 1].isHasChip()
                                    && cells[cell.getLeftCellNumber() - 1].isHasChip()
                                    && cells[cell.getLeftCellNumber() - 2].isHasChip()) {
                                chipsValue = 0;
                                chipsValue += cell.getChipValue();
                                chipsValue += cells[cell.getLeftCellNumber() - 1].getChipValue();
                                chipsValue += cells[cell.getLeftCellNumber() - 2].getChipValue();
                                chipsValue += cells[cell.getBottomCellNumber() - 1].getChipValue();
                                payoutMultiplier = 8;
                            }
                            if(cell.getRightCellNumber() != 0 && cells[cell.getBottomCellNumber() - 1].isHasChip()
                                    && cells[cell.getRightCellNumber() - 1].isHasChip()
                                    && cells[cell.getRightCellNumber() - 2].isHasChip()) {
                                chipsValue = 0;
                                chipsValue += cell.getChipValue();
                                chipsValue += cells[cell.getRightCellNumber() - 1].getChipValue();
                                chipsValue += cells[cell.getRightCellNumber() - 2].getChipValue();
                                chipsValue += cells[cell.getBottomCellNumber() - 1].getChipValue();

                                payoutMultiplier = 8;
                            }
                        }
                    }
                }
            }
        }

        System.out.println("chipValue here asdf asdf: " + chipsValue);
        int totalReturn = payoutMultiplier * chipsValue + chipsValue;

        System.out.println("Player wins: " + (totalReturn - chipsValue));
        return totalReturn;
    }
}
