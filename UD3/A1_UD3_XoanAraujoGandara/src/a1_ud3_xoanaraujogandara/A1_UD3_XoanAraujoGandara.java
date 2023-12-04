package a1_ud3_xoanaraujogandara;

public class A1_UD3_XoanAraujoGandara {

    public static void main(String[] args) {
        MSSMSConection con = new  MSSMSConection("BDEmpresa", "sa", "abc123.");
        String createLugar = """
                                USE BDEmpresa;
                                    IF OBJECT_ID('LUGAR', 'U') IS NOT NULL
                                        DROP TABLE LUGAR;
                                    
                                      CREATE TABLE LUGAR(
                                          Lugar varchar(25) not null,
                                          Num_departamento int not null,
                                          CONSTRAINT PK_Lugar_Departamento PRIMARY KEY(Lugar, Num_departamento),
                                          CONSTRAINT FK_NumeroDpt FOREIGN KEY (Num_departamento) REFERENCES DEPARTAMENTO(Num_departamento)
                                          ON DELETE CASCADE ON UPDATE CASCADE
                                      );""";
        con.update(createLugar);
    }
}
