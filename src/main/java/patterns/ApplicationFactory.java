package patterns;

public class ApplicationFactory {

    public Application getApplication(String appl){
        if(null == appl){
            return null;
        }else if(appl.equals("loan")){
            return new LoanApplication();
        }else if(appl.equals("borrower")){
            return new BorrowerApplication();
        }
        return null;
    }
}
