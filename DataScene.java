import org.code.theater.*;



public class DataScene extends Scene {
  private Person[] people;  // Declare people array

  /** Constructor */
  public DataScene() {
    people = createPeople();  // Initialize people array
  }

  /** Returns a 1D array of Person objects using the txt files in this project */
  public Person[] createPeople() {
    String[] namesArray = FileReader.toStringArray("names.txt");
    int[] agesArray = FileReader.toIntArray("ages.txt");
    
    Person[] peopleArray = new Person[namesArray.length];
    for (int i = 0; i < peopleArray.length; i++) {
      peopleArray[i] = new Person(namesArray[i], agesArray[i]);
    }

    return peopleArray;
  }

  /**
   * Method to draw the bar chart
   */
  public void drawScene() {
    for (int frame = 0; frame <= 100; frame++) {
       
        int barWidth = 20;
        int spacing = 10;
        int startX = 10;

       for (int i = 0; i < people.length; i++) {
      // Get the max height for the bar (age * 5)
      int maxHeight = people[i].getAge() * 5;

      // Use a random factor to slightly vary the height of the bars
      double randomFactor = Math.random() * 0.2 + 0.9;  // Random value between 0.9 and 1.1
      int barHeight = (int) (maxHeight * (frame / 100.0) * randomFactor);

      int x = startX + i * (barWidth + spacing);
      int y = 400 - barHeight;

      // Use Math.round() to smooth the bar height
      barHeight = (int) Math.round(barHeight);
          

            // Sets the length and width of bar
            drawRectangle(x, y, barWidth, barHeight);

            // Draw the text for the name
            drawText(people[i].getName(), x, 410);
         
           // Draw the age slightly above the top of the bar
      drawText(String.valueOf(people[i].getAge()) + " years", x + barWidth / 2 - 10, y - 10);  // Age above the bar
           
     }
    }
  }
}