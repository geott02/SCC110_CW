
public class mainClass {

    private Rectangle rectangle;
    private Ball ball;
    private Ball innerMiddle;
    private Ball outerMiddle;
    private Ball player1;
    private Ball player2;
    private Line lineTop;
    private Line lineBottom;
    private Line lineLeft;
    private Line lineRight;
    private Line lineMiddleTop;
    private Line lineMiddleBottom;
    private Line linePlayer1Goal;
    private Line linePlayer2Goal;
   // private GameArena game;

public static void main(String[] args) {

    GameArena game =new GameArena(700,400,true);
    
    Rectangle rectangle = new Rectangle(50, 50, 600, 300, "WHITE");
    game.addRectangle(rectangle);
    
    Ball ball = new Ball(350, 200, 16, "BLACK",4);
    game.addBall(ball);

    Ball innerMiddle = new Ball(350, 200, 88, "WHITE",3);
    game.addBall(innerMiddle);

    Ball outerMiddle = new Ball(350, 200, 90, "BLUE",2);
    game.addBall(outerMiddle);

    Ball player1 = new Ball(150, 200, 50, "BLACK",4);
    game.addBall(player1);

    Ball player2 = new Ball(550, 200, 50, "BLACK",4);
    game.addBall(player2);

    Line lineTop = new Line(50,50,650,50,20,"RED",6);
    game.addLine(lineTop);
     
    Line lineBottom = new Line(50,350,650,350,20,"RED",6);
    game.addLine(lineBottom);

    Line lineLeft = new Line(50,350,50,50,20,"BLUE",6);
    game.addLine(lineLeft);

    Line lineRight = new Line(650,350,650,50,20,"BLUE",6);
    game.addLine(lineRight);

    Line lineMiddleTop = new Line(350,155,350,50,2,"RED",6);
    game.addLine(lineMiddleTop);

    Line lineMiddleBottom = new Line(350,245,350,350,2,"RED",6);
    game.addLine(lineMiddleBottom);

    Line player1Goal = new Line(60,150,60,250,10,"GREY",7);
    game.addLine(player1Goal);

    Line player2Goal = new Line(640,150,640,250,10,"GREY",7);
    game.addLine(player2Goal);

    while(true){
        if (game.upPressed())
        if(player1.getYPosition() > 85)
        player1.move(0,-5);

        if (game.downPressed())
        if(player1.getYPosition() < 315)
        player1.move(0,5);

        if (game.leftPressed())
        if(player1.getXPosition() > 85) 
        player1.move(-5,0);

        if (game.rightPressed())
        if(player1.getXPosition() < 325)
        player1.move(5,0);

        if (game.letterPressed('w'))
        if(player2.getYPosition() > 85)
        player2.move(0,-5);

        if (game.letterPressed('s'))
        if(player2.getYPosition() < 315) 
        player2.move(0,5);

        if (game.letterPressed('a'))
        if(player2.getXPosition() > 375) 
        player2.move(-5,0);

        if (game.letterPressed('d'))
        if(player2.getXPosition() < 615) 
        player2.move(5,0);


        game.pause();
    }
}
}
