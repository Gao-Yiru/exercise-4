public class Feedback {
    private String firstName;
    private String lastName;
    private String email;

    private String completeFeedback;
    private String reviewID;
    private boolean longFeedback;

    public Feedback(String firstName,String lastName,String email){
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public String getFirstName(){
        return firstName;
    }
    public String getLastName(){
        return lastName;
    }
    public String getEmail(){
        return email;
    }

    public void analyseFeedBack(boolean isConcatenation, String sent1, String sent2,String sent3,String sent4,String sent5){
        if(isConcatenation){
            completeFeedback = feedbackUsingConcatenation(sent1,sent2,sent3,sent4,sent5);
            checkFeedbackLength(completeFeedback);
            createReviewID(firstName, lastName, completeFeedback);
        }else{
            completeFeedback = feedbackUsingStringBuilder(sent1, sent2,sent3,sent4,sent5).toString();
            checkFeedbackLength(completeFeedback);
            createReviewID(firstName, lastName, completeFeedback);
        }
    }

    private String feedbackUsingConcatenation(String sent1,String sent2,String sent3,String sent4,String sent5){
        String concatenatedFeedback="";
        concatenatedFeedback = sent1+" ";
        concatenatedFeedback += sent2+" "+sent3+" "+sent4+" "+sent5;
        return concatenatedFeedback;
    }

    private StringBuilder feedbackUsingStringBuilder(String sent1,String sent2,String sent3,String sent4,String sent5){
        StringBuilder sb = new StringBuilder();
        sb.append(sent1).append(" ").append(sent2).append(" ").append(sent3).append(" ").append(sent4).append(" ").append(sent5);
        return sb;
    }

    private boolean checkFeedbackLength(String completeFeedback){
        if(completeFeedback.length()>500){
            longFeedback = true;
            return longFeedback;
        }else{
            longFeedback = false;
            return longFeedback;
        }
    }
    private void createReviewID(String firstName,String lastName,String completeFeedBack){
        reviewID=(firstName+lastName).substring(2,6).toUpperCase();
        reviewID+=completeFeedBack.substring(10,15).toLowerCase();
        reviewID+=(completeFeedBack.length());
        reviewID+="_";
        reviewID+=System.currentTimeMillis();
        reviewID=reviewID.replace(" ", "");
    }

    @Override
    public String toString(){
        String tem = "Feedback from " + firstName+ " "+lastName+" {"+email+"}\n\n"+
        "Feedback: "+completeFeedback+"\n\nIf the feedback is long than 500? "+longFeedback+
        "\n\nThe review ID: "+reviewID;
        return tem;
    }
}