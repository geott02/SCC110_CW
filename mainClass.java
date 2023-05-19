
public class mainClass {

    private Rectangle rectangle;
    private Ball puck;
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
    private GameArena game;
    private static double xPuckSpeed = 0;
    private static double yPuckSpeed = 0;
    private static double yPlayer1Speed = 1;
    private static double xPlayer1Speed = 1;
    private static double yPlayer2Speed = 1;
    private static double xPlayer2Speed = 1;
    private static int player1Score = 0;
    private static int player2Score = 0;


public static void main(String[] args) {

    GameArena game =new GameArena(700,400,true);
    
   // mainClass applyFriction = new mainClass();

    mainClass gameInstance = new mainClass();

    Rectangle rectangle = new Rectangle(50, 50, 600, 300, "WHITE");
    game.addRectangle(rectangle);
    
    Ball puck = new Ball(350, 200, 16, "BLACK",6);
    game.addBall(puck);

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

    Line lineMiddleTop = new Line(350,155,350,50,2,"RED",5);
    game.addLine(lineMiddleTop);

    Line lineMiddleBottom = new Line(350,245,350,350,2,"RED",5);
    game.addLine(lineMiddleBottom);

    Line player1Goal = new Line(60,150,60,250,10,"GREY",7);
    game.addLine(player1Goal);

    Line player2Goal = new Line(640,150,640,250,10,"GREY",7);
    game.addLine(player2Goal);

    Text player1Counter = new Text("The Score is:",100,350,200,"BLACK",10);



    while(true){

        
        if (game.upPressed())
        if(player1.getYPosition() > 85){
        yPlayer1Speed = -2;
        player1.move(0,-5);
        }

        if (game.downPressed())
        if(player1.getYPosition() < 315){
        yPlayer1Speed = 2;
        player1.move(0,5);
        }

        if (game.leftPressed())
        if(player1.getXPosition() > 85){
        xPlayer1Speed = -2;
        player1.move(-5,0);
        }

        if (game.rightPressed())
        if(player1.getXPosition() < 325){
        xPlayer1Speed = 2;
        player1.move(5,0);
        }

        if (game.letterPressed('w'))
        if(player2.getYPosition() > 85){
        yPlayer2Speed = -2;
        player2.move(0,-5);
        }

        if (game.letterPressed('s'))
        if(player2.getYPosition() < 315){ 
        yPlayer2Speed = 2;
        player2.move(0,5);
        }
        
        if (game.letterPressed('a'))
        if(player2.getXPosition() > 375){ 
        xPlayer2Speed = -2;
        player2.move(-5,0);
        }

        if (game.letterPressed('d'))
        if(player2.getXPosition() < 615){
        xPlayer2Speed = 2;
        player2.move(5,0);
        }

        if(puck.getXPosition() <= 68){
        puck.setXPosition(68);
        xPuckSpeed = xPuckSpeed * -1;
        }

        if(puck.getXPosition() >= 632){
        puck.setXPosition(632);    
        xPuckSpeed = xPuckSpeed * -1;
        }

        if(puck.getYPosition() <= 68){
        puck.setYPosition(68);    
        yPuckSpeed = yPuckSpeed * -1;
        }
        
        if(puck.getYPosition() >= 332){
        puck.setYPosition(332);    
        yPuckSpeed = yPuckSpeed * -1;
        }
        
        if (puck.getXPosition() <= 68 && puck.getYPosition() <=250 && puck.getYPosition() >=150 ) {
        player1Score++;
        System.out.println("Player 1 scores!");
        yPuckSpeed = 0;
        xPuckSpeed = 0;
        puck.setXPosition(325);
        puck.setYPosition(200);
        player1.setXPosition(150);
        player1.setYPosition(200);
        player2.setXPosition(550);
        player2.setYPosition(200);
        }

        if (puck.getXPosition() >= 632 && puck.getYPosition() <=250 && puck.getYPosition() >=150 ) {
        player2Score++;
        System.out.println("Player 2 scores!");
        yPuckSpeed = 0;
        xPuckSpeed = 0;
        puck.setXPosition(375);
        puck.setYPosition(200);
        player1.setXPosition(150);
        player1.setYPosition(200);
        player2.setXPosition(550);
        player2.setYPosition(200);
        }

        if (player1.collides(puck))
        gameInstance.deflect(puck.getXPosition(), player1.getXPosition(), puck.getYPosition(), player1.getYPosition(), xPuckSpeed, xPlayer1Speed, yPuckSpeed, yPlayer1Speed);

        if (player2.collides(puck))
        gameInstance.deflect(puck.getXPosition(), player2.getXPosition(), puck.getYPosition(), player2.getYPosition(), xPuckSpeed, xPlayer2Speed, yPuckSpeed, yPlayer2Speed);

        puck.setXPosition(puck.getXPosition() + xPuckSpeed);
        puck.setYPosition(puck.getYPosition() + yPuckSpeed);

        gameInstance.applyFriction();

        game.pause();
    }



    
 }
    public void applyFriction(){
    xPuckSpeed = xPuckSpeed * 0.99;
    yPuckSpeed = yPuckSpeed * 0.99;   
 }


 public void deflect(double xPosition1, double xPosition2, double yPosition1, double yPosition2, double xSpeed1, double xSpeed2, double ySpeed1, double ySpeed2){
    // The position and speed of each of the two balls in the x and y axis before collision.
    // YOU NEED TO FILL THESE VALUES IN AS APPROPRIATE...
    //double xPosition1, xPosition2, yPosition1, yPosition2;
    //double xSpeed1, xSpeed2, ySpeed1, ySpeed2;
    // Calculate initial momentum of the balls... We assume unit mass here.
    double p1InitialMomentum = Math.sqrt(xSpeed1 * xSpeed1 + ySpeed1 * ySpeed1);
    double p2InitialMomentum = Math.sqrt(xSpeed2 * xSpeed2 + ySpeed2 * ySpeed2);
    // calculate motion vectors
    double[] p1Trajectory = {xSpeed1, ySpeed1};
    double[] p2Trajectory = {xSpeed2, ySpeed2};
    // Calculate Impact Vector
    double[] impactVector = {xPosition2 - xPosition1, yPosition2 - yPosition1};
    double[] impactVectorNorm = normalizeVector(impactVector);
    // Calculate scalar product of each trajectory and impact vector
    double p1dotImpact = Math.abs(p1Trajectory[0] * impactVectorNorm[0] + p1Trajectory[1] * impactVectorNorm[1]);
    double p2dotImpact = Math.abs(p2Trajectory[0] * impactVectorNorm[0] + p2Trajectory[1] * impactVectorNorm[1]);
    // Calculate the deflection vectors - the amount of energy transferred from one ball to the other in each axis
    double[] p1Deflect = { -impactVectorNorm[0] * p2dotImpact, -impactVectorNorm[1] * p2dotImpact };
    double[] p2Deflect = { impactVectorNorm[0] * p1dotImpact, impactVectorNorm[1] * p1dotImpact };
    // Calculate the final trajectories
    double[] p1FinalTrajectory = {p1Trajectory[0] + p1Deflect[0] - p2Deflect[0], p1Trajectory[1] + p1Deflect[1] - p2Deflect[1]};
    double[] p2FinalTrajectory = {p2Trajectory[0] + p2Deflect[0] - p1Deflect[0], p2Trajectory[1] + p2Deflect[1] - p1Deflect[1]};
    // Calculate the final energy in the system.
    double p1FinalMomentum = Math.sqrt(p1FinalTrajectory[0] * p1FinalTrajectory[0] + p1FinalTrajectory[1] * p1FinalTrajectory[1]);
    double p2FinalMomentum = Math.sqrt(p2FinalTrajectory[0] * p2FinalTrajectory[0] + p2FinalTrajectory[1] * p2FinalTrajectory[1]);
   
    // Scale the resultant trajectories if we've accidentally broken the laws of physics.
    double mag = (p1InitialMomentum + p2InitialMomentum) / (p1FinalMomentum + p2FinalMomentum);
    // Calculate the final x and y speed settings for the two balls after collision.
    xSpeed1 = p1FinalTrajectory[0] * mag;
    ySpeed1 = p1FinalTrajectory[1] * mag;
    xSpeed2 = p2FinalTrajectory[0] * mag;
    ySpeed2 = p2FinalTrajectory[1] * mag;
    
    xPuckSpeed = xSpeed1;
    yPuckSpeed = ySpeed1;
    }

    /**
    * Converts a vector into a unit vector.
    * Used by the deflect() method to calculate the resultant direction after a collision.
    */
    private double[] normalizeVector(double[] vec)
    {
    double mag = 0.0;
    int dimensions = vec.length;
    double[] result = new double[dimensions];
    for (int i=0; i < dimensions; i++)
    mag += vec[i] * vec[i];
    mag = Math.sqrt(mag);
    if (mag == 0.0)
    {
    result[0] = 1.0;
    for (int i=1; i < dimensions; i++)
    result[i] = 0.0;
    }
    else
    {
    for (int i=0; i < dimensions; i++)
    result[i] = vec[i] / mag;
    }
    return result;
    }
}


