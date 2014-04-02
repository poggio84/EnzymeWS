package uk.ac.ebi.enzyme.model;

/**
 *
 * @author Diego Poggioli
 *
 *
 */
public class Ec {

    /*
    The ID  (IDentification) line  is always the first line of an entry. The
    format of the ID line is:

    ID   EC_number
    Examples:

    ID   1.1.1.1
    ID   6.3.2.1
    ID   3.5.1.n3

    Note
    -  EC numbers  that include  an 'n' as part of the fourth (serial) digit
    are preliminary EC numbers.
            -  Entries  with preliminary  EC numbers  are placed  at the  end of the
    sub-sub-class to which they belong.
            -  Preliminary  EC numbers  are  not  included  in  the  official  IUBMB
    nomenclature,  but   are  created   and  used   only  in  ENZYME  and
    UniProtKB/Swiss-Prot
    */
    private String id;

    /*
    DE   Description.

    Examples:

    DE   Alcohol dehydrogenase.

    DE   UDP-N-acetylmuramoylalanyl-D-glutamyl-2,6-diaminopimelate--D-
    DE   alanyl-D-alanyl ligase.

    Important note:  enzymes are  sometimes deleted from the EC list, others
    are renumbered;  however the  NC-IUBMB does not allocate the old numbers
    to new  enzymes. Obsolete  EC numbers are indicated in this database  by
    the following DE line syntaxes. For deleted enzymes:

    DE   Deleted entry.

            and for renumbered enzymes:

    DE   Transferred entry: x.x.x.x.

    where x.x.x.x  is the  new, valid,  EC number; as shown in the following
    example:

    DE   Transferred entry: 1.7.99.5.
    */
    private String de;

    /*
    The AN  (Alternate Name)  line(s) are  used to  indicate  the  different
   name(s), other  than the NC-IUBMB recommended name, that are used in the
   literature to describe an enzyme. The format of the AN line is:

   AN   Alternate_Name.

   As an  example we  list here  both the DE and AN lines for the enzyme EC
   2.7.7.31:

   DE   DNA nucleotidylexotransferase.
   AN   Terminal addition enzyme.
   AN   Terminal deoxynucleotidyltransferase.
   AN   Terminal deoxyribonucleotidyltransferase.
   AN   Terminal transferase.
   */
    private String an;

    /**
     * The CA (Catalytic Activity) line(s) are used to indicate the reaction(s) xcatalyzed by an enzyme.
     */
    private String ca;

    public String getId() {
        return id;
    }

    public String getDe() {
        return de;
    }

    public String getAn() {
        return an;
    }

    public String getCa() {
        return ca;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setDe(String de) {
        this.de = de;
    }

    public void setAn(String an) {
        this.an = an;
    }

    public void setCa(String ca) {
        this.ca = ca;
    }

    @Override
    public String toString() {
        return "Ec{" +
                "id='" + id + '\'' +
                ", de='" + de + '\'' +
                ", an='" + an + '\'' +
                ", ca='" + ca + '\'' +
                '}';
    }
}
