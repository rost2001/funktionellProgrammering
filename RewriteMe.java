package inlamning1;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
Inlämningsuppgit i kursen Funktionell Programmering för JAVA-programmet
För samtliga funktioner i denna fil, byt ut "throw UnSupportedException"-raden
och skriv ett pipeline-uttryck som returnerar det som ska returneras.
Streams MÅSTE användas i samtliga funktioner som lämnas in
För att testa om era funktioner funkar, kör testerna som hör till denna fil
För att bli godkänd på denna uppgift måste minst 7 av funktionerna vara implementerade.
Sigruns bedömning av denna uppgift kommer att gå till så att hon klipper in er version av denna fil
i sitt projekt och kör testerna.
Hennes kontroll om ni har klarat uppgifterna eller inte görs genom att
hon kollar att tillräckeligt många av tester går gröna. Pga detta ska ni inte ändra i någon fil
medföljande detta projekt, och inte heller metodsignaturerna i denna fil eller era tester, eftersom
ni då riskerar att påverka rättningen i negativ riktning.
 */

public class RewriteMe {

    public Database database = new Database();
    public List<Question> questions = database.getQuestions();

    //Skriv en funktioner som returnerar hur många frågor det finns i databasen?
    public int getAmountOfQuestionsInDatabase(){
        int numOfQuest = (int) questions.stream().count();
        return numOfQuest;
    }

    //Hur många frågor finns i databasen för en viss, given kategori (som ges som inparameter)
    public int getAmountOfQuestionsForACertainCategory(Category category){
        int numOfQuestByCat = (int) questions.stream().filter(c -> c.getCategory().equals(category)).count();
        return numOfQuestByCat;
    }

    //Skapa en lista innehållandes samtliga frågesträngar i databasen
    public List<String> getListOfAllQuestions(){
        List<String> allQuest=new ArrayList<>( );
        questions.stream().forEach(q->{allQuest.add(q.getQuestionString());});
        return allQuest;
    }

    //Skapa en lista innehållandes samtliga frågesträngar där frågan tillhör en viss kategori
    //Kategorin ges som inparameter
    public List<String> getAllQuestionStringsBelongingACategory(Category category){
        List<String> allQuestByCat=new ArrayList<>( );
        questions.stream().filter(c -> c.getCategory().equals(category))
                .forEach(q->{allQuestByCat.add(q.getQuestionString());});
        return allQuestByCat;
    }

    //Skapa en lista av alla svarsalternativ, där varje svarsalternativ får förekomma
    // en och endast en gång i den lista som du ska returnera
    public List<String> getAllAnswerOptionsDistinct(){
        List<String> allAnswers=new ArrayList<>();
        for (int i =0; i<questions.size();i++) {
            List<String> ans = questions.get(i).getAllAnswers();
            for (int j =0; j<ans.size();j++) {
                allAnswers.add(ans.get(j));
            }
        }
        List<String> dist = allAnswers.stream().distinct().collect(Collectors.toList());
        return dist;
    }


    //Finns en viss sträng, given som inparameter, som svarsalternativ till någon fråga i vår databas?
    public boolean isThisAnAnswerOption(String answerCandidate){
        List<String> allAnswers=new ArrayList<>();
        for (int i =0; i<questions.size();i++) {
            List<String> ans = questions.get(i).getAllAnswers();
            for (int j =0; j<ans.size();j++) {
                allAnswers.add(ans.get(j));
            }
        }
        Optional<String> found = allAnswers.stream().filter(a->a.contains(answerCandidate)).findFirst();
        if (found.isPresent()) {
            return true;
        }
        return false;
    }

    //Hur ofta förekommer ett visst svarsalternativ, givet som inparameter, i databasen
    public int getAnswerCandidateFrequncy(String answerCandidate){
        List<String> allAnswers=new ArrayList<>();
        for (int i =0; i<questions.size();i++) {
            List<String> ans = questions.get(i).getAllAnswers();
            for (int j =0; j<ans.size();j++) {
                allAnswers.add(ans.get(j));
            }
        }
        List<String> freq = allAnswers.stream().filter(s->s.equals(answerCandidate)).collect(Collectors.toList());
        return freq.size();
    }

    //Skapa en Map där kategorierna är nycklar och värdena är en lista
    //av de frågesträngar som tillhör varje kategori
    public Map<Category, List<String>> getQuestionGroupedByCategory(){

        throw new UnsupportedOperationException("Not supported yet.");
    }

    //Skapa en funktion som hittar det svarsalternativ som har flest bokstäver, i en kategori, given som inparameter
    // OBS: Du måste använda Reduce!
    public String getLongestLettercountAnwerInAGivenCategory(Category c)
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }


    public static void main(String[] args){
        RewriteMe uppg4 = new RewriteMe();

    }

}
