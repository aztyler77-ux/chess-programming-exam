package chess;

import java.util.Collection;
import java.util.Objects;
import java.util.ArrayList;

public class ChessPiece {
    private final ChessGame.TeamColor pieceColor;
    private final ChessPiece.PieceType type;

    public ChessPiece(ChessGame.TeamColor pieceColor, ChessPiece.PieceType type) {
        this.pieceColor = pieceColor;
        this.type = type;
    }

    public enum PieceType {
        KING,
        QUEEN,
        BISHOP,
        KNIGHT,
        ROOK,
        PAWN
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ChessPiece that = (ChessPiece) o;
        return pieceColor == that.pieceColor && type == that.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(pieceColor, type);
    }

    public ChessGame.TeamColor getTeamColor() {
        return pieceColor;
    }

    public PieceType getPieceType() {
        return type;
    }

    public Collection<ChessMove> pieceMoves(ChessBoard board, ChessPosition myPosition) {
        Collection<ChessMove> pieceMoves = new ArrayList<>();

        if (type == PieceType.ROOK) {
            int[][] rookMoves = {
                    {1,0},
                    {-1,0},
                    {0,-1},
                    {0,1}
            };
            for (int[] move : rookMoves) {
                int myRow = myPosition.getRow();
                int myCol = myPosition.getColumn();
                int rowMove = move[0];
                int colMove = move[1];
                int newRow = myRow + rowMove;
                int newCol = myCol + colMove;
                while (newRow >= 1 && newRow <= 8 && newCol >= 1 && newCol <= 8) {
                    ChessPosition newPosition = new ChessPosition(newRow, newCol);
                    ChessPiece newPiece = board.getPiece(newPosition);
                    if (newPiece == null) {
                        pieceMoves.add(new ChessMove(myPosition, newPosition, null));
                    } else {
                        if (newPiece.getTeamColor() != pieceColor) {
                            pieceMoves.add(new ChessMove(myPosition, newPosition, null));
                        }
                        break;
                    }
                    newRow = newRow + rowMove;
                    newCol = newCol + colMove;
                }
            }
        }

        if (type == PieceType.KNIGHT) {
            int[][] knightMoves = {
                    {-2,-1},
                    {-2,1},
                    {2,-1},
                    {2,1},
                    {-1,-2},
                    {-1,2},
                    {1,-2},
                    {1,2}
            };
            for (int[] move : knightMoves) {
                int myRow = myPosition.getRow();
                int myCol = myPosition.getColumn();
                int rowMove = move[0];
                int colMove = move[1];
                int newRow = myRow + rowMove;
                int newCol = myCol + colMove;
                if (newRow >= 1 && newRow <= 8 && newCol >= 1 && newCol <= 8) {
                    ChessPosition newPosition = new ChessPosition(newRow, newCol);
                    ChessPiece newPiece = board.getPiece(newPosition);
                    if (newPiece == null) {
                        pieceMoves.add(new ChessMove(myPosition, newPosition, null));
                    } else {
                        if (newPiece.getTeamColor() != pieceColor) {
                            pieceMoves.add(new ChessMove(myPosition, newPosition, null));
                        }
                    }
                }
            }
        }

        if (type == PieceType.BISHOP) {
            int[][] bishopMoves = {
                    {1,-1},
                    {1,1},
                    {-1,-1},
                    {-1,1}
            };
            for (int[] move : bishopMoves) {
                int myRow = myPosition.getRow();
                int myCol = myPosition.getColumn();
                int rowMove = move[0];
                int colMove = move[1];
                int newRow = myRow + rowMove;
                int newCol = myCol + colMove;
                while (newRow >= 1 && newRow <= 8 && newCol >= 1 && newCol <= 8) {
                    ChessPosition newPosition = new ChessPosition(newRow, newCol);
                    ChessPiece newPiece = board.getPiece(newPosition);
                    if (newPiece == null) {
                        pieceMoves.add(new ChessMove(myPosition, newPosition, null));
                    } else {
                        if (newPiece.getTeamColor() != pieceColor) {
                            pieceMoves.add(new ChessMove(myPosition, newPosition, null));
                        }
                        break;
                    }
                    newRow = newRow + rowMove;
                    newCol = newCol + colMove;
                }
            }
        }

            if (type == PieceType.QUEEN) {
            int[][] queenMoves = {
                    {1,0},
                    {-1,0},
                    {0,-1},
                    {0,1},
                    {1,-1},
                    {1,1},
                    {-1,-1},
                    {-1,1}
            };
            for (int[] move : queenMoves) {
                int myRow = myPosition.getRow();
                int myCol = myPosition.getColumn();
                int rowMove = move[0];
                int colMove = move[1];
                int newRow = myRow + rowMove;
                int newCol = myCol + colMove;
                while (newRow >= 1 && newRow <= 8 && newCol >= 1 && newCol <= 8) {
                    ChessPosition newPosition = new ChessPosition(newRow, newCol);
                    ChessPiece newPiece = board.getPiece(newPosition);
                    if (newPiece == null) {
                        pieceMoves.add(new ChessMove(myPosition, newPosition, null));
                    } else {
                        if (newPiece.getTeamColor() != pieceColor) {
                            pieceMoves.add(new ChessMove(myPosition, newPosition, null));
                        }
                        break;
                    }
                    newRow = newRow + rowMove;
                    newCol = newCol + colMove;
                }
            }
        }

        if (type == PieceType.KING) {
            int[][] kingMoves = {
                    {1,-1},
                    {1,0},
                    {1,1},
                    {0,-1},
                    {0,1},
                    {-1,-1},
                    {-1,0},
                    {-1,1}
            };
            for (int[] move : kingMoves) {
                int myRow = myPosition.getRow();
                int myCol = myPosition.getColumn();
                int rowMove = move[0];
                int colMove = move[1];
                int newRow = myRow + rowMove;
                int newCol = myCol + colMove;
                if (newRow >= 1 && newRow <= 8 && newCol >= 1 && newCol <= 8) {
                    ChessPosition newPosition = new ChessPosition(newRow, newCol);
                    ChessPiece newPiece = board.getPiece(newPosition);
                    if (newPiece == null) {
                        pieceMoves.add(new ChessMove(myPosition, newPosition, null));
                    } else {
                        if (newPiece.getTeamColor() != pieceColor) {
                            pieceMoves.add(new ChessMove(myPosition, newPosition, null));
                        }
                    }
                }
            }
        }
        
        if (type == PieceType.PAWN) {
            if (pieceColor == ChessGame.TeamColor.WHITE) {
                int myRow = myPosition.getRow();
                int myCol = myPosition.getColumn();
                // forward
                if ((myRow + 1) <= 8) {
                    ChessPosition forward = new ChessPosition(myRow + 1, myCol);
                    ChessPiece forwardPiece = board.getPiece(forward);
                    if (forwardPiece == null) {
                        if (forward.getRow() == 8) {
                            pieceMoves.add(new ChessMove(myPosition, forward, PieceType.ROOK));
                            pieceMoves.add(new ChessMove(myPosition, forward, PieceType.KNIGHT));
                            pieceMoves.add(new ChessMove(myPosition, forward, PieceType.BISHOP));
                            pieceMoves.add(new ChessMove(myPosition, forward, PieceType.QUEEN));
                        } else {
                            pieceMoves.add(new ChessMove(myPosition, forward, null));
                        }
                    }
                }
                // initial
                if (myRow == 2) {
                    ChessPosition forward = new ChessPosition(myRow + 1, myCol);
                    ChessPiece forwardPiece = board.getPiece(forward);
                    ChessPosition forward2 = new ChessPosition(myRow + 2, myCol);
                    ChessPiece forward2Piece = board.getPiece(forward2);
                    if (forwardPiece == null) {
                        if (forward2Piece == null) {
                            pieceMoves.add(new ChessMove(myPosition, forward2, null));
                        }
                    }
                }
                // attack left
                if ((myRow + 1) <= 8 && (myCol - 1 ) >= 1) {
                    ChessPosition attackLeft = new ChessPosition(myRow + 1, myCol - 1);
                    ChessPiece attackLeftPiece = board.getPiece(attackLeft);
                    if (attackLeftPiece != null) {
                        if (attackLeftPiece.getTeamColor() != pieceColor) {
                            if (attackLeft.getRow() == 8) {
                                pieceMoves.add(new ChessMove(myPosition, attackLeft, PieceType.ROOK));
                                pieceMoves.add(new ChessMove(myPosition, attackLeft, PieceType.KNIGHT));
                                pieceMoves.add(new ChessMove(myPosition, attackLeft, PieceType.BISHOP));
                                pieceMoves.add(new ChessMove(myPosition, attackLeft, PieceType.QUEEN));
                            } else {
                                pieceMoves.add(new ChessMove(myPosition, attackLeft, null));
                            }
                        }
                    }
                }
                // attack right
                if ((myRow + 1) <= 8 && (myCol + 1 ) <= 8) {
                    ChessPosition attackRight = new ChessPosition(myRow + 1, myCol + 1);
                    ChessPiece attackRightPiece = board.getPiece(attackRight);
                    if (attackRightPiece != null) {
                        if (attackRightPiece.getTeamColor() != pieceColor) {
                            if (attackRight.getRow() == 8) {
                                pieceMoves.add(new ChessMove(myPosition, attackRight, PieceType.ROOK));
                                pieceMoves.add(new ChessMove(myPosition, attackRight, PieceType.KNIGHT));
                                pieceMoves.add(new ChessMove(myPosition, attackRight, PieceType.BISHOP));
                                pieceMoves.add(new ChessMove(myPosition, attackRight, PieceType.QUEEN));
                            } else {
                                pieceMoves.add(new ChessMove(myPosition, attackRight, null));
                            }
                        }
                    }
                }
            }







            if (pieceColor == ChessGame.TeamColor.BLACK) {
                int myRow = myPosition.getRow();
                int myCol = myPosition.getColumn();
                // forward
                if ((myRow - 1) >= 1) {
                    ChessPosition forward = new ChessPosition(myRow - 1, myCol);
                    ChessPiece forwardPiece = board.getPiece(forward);
                    if (forwardPiece == null) {
                        if (forward.getRow() == 1) {
                            pieceMoves.add(new ChessMove(myPosition, forward, PieceType.ROOK));
                            pieceMoves.add(new ChessMove(myPosition, forward, PieceType.KNIGHT));
                            pieceMoves.add(new ChessMove(myPosition, forward, PieceType.BISHOP));
                            pieceMoves.add(new ChessMove(myPosition, forward, PieceType.QUEEN));
                        } else {
                            pieceMoves.add(new ChessMove(myPosition, forward, null));
                        }
                    }
                }
                // initial
                if (myRow == 7) {
                    ChessPosition forward = new ChessPosition(myRow - 1, myCol);
                    ChessPiece forwardPiece = board.getPiece(forward);
                    ChessPosition forward2 = new ChessPosition(myRow - 2, myCol);
                    ChessPiece forward2Piece = board.getPiece(forward2);
                    if (forwardPiece == null) {
                        if (forward2Piece == null) {
                            pieceMoves.add(new ChessMove(myPosition, forward2, null));
                        }
                    }
                }
                // attack left
                if ((myRow - 1) >= 1 && (myCol - 1 ) >= 1) {
                    ChessPosition attackLeft = new ChessPosition(myRow - 1, myCol - 1);
                    ChessPiece attackLeftPiece = board.getPiece(attackLeft);
                    if (attackLeftPiece != null) {
                        if (attackLeftPiece.getTeamColor() != pieceColor) {
                            if (attackLeft.getRow() == 1) {
                                pieceMoves.add(new ChessMove(myPosition, attackLeft, PieceType.ROOK));
                                pieceMoves.add(new ChessMove(myPosition, attackLeft, PieceType.KNIGHT));
                                pieceMoves.add(new ChessMove(myPosition, attackLeft, PieceType.BISHOP));
                                pieceMoves.add(new ChessMove(myPosition, attackLeft, PieceType.QUEEN));
                            } else {
                                pieceMoves.add(new ChessMove(myPosition, attackLeft, null));
                            }
                        }
                    }
                }
                // attack right
                if ((myRow - 1) >= 1 && (myCol + 1 ) <= 8) {
                    ChessPosition attackRight = new ChessPosition(myRow - 1, myCol + 1);
                    ChessPiece attackRightPiece = board.getPiece(attackRight);
                    if (attackRightPiece != null) {
                        if (attackRightPiece.getTeamColor() != pieceColor) {
                            if (attackRight.getRow() == 1) {
                                pieceMoves.add(new ChessMove(myPosition, attackRight, PieceType.ROOK));
                                pieceMoves.add(new ChessMove(myPosition, attackRight, PieceType.KNIGHT));
                                pieceMoves.add(new ChessMove(myPosition, attackRight, PieceType.BISHOP));
                                pieceMoves.add(new ChessMove(myPosition, attackRight, PieceType.QUEEN));
                            } else {
                                pieceMoves.add(new ChessMove(myPosition, attackRight, null));
                            }
                        }
                    }
                }
            }












        }

        return pieceMoves;
    }
}
