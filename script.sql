WITH numbered_rows AS (SELECT *, ROW_NUMBER() OVER (PARTITION BY id_voiture ORDER BY date_statut  DESC) as rn FROM statut_voiture ) SELECT * FROM numbered_rows WHERE rn = 1

    INSERT INTO statut_voiture (id_statut, date_statut, statut, id_voiture) values
    (1,'2024-01-01',10,1),(2,'2024-01-02',20,1),(3,'2024-01-03',15,1),
    (1,'2024-01-01',10,2),(2,'2024-01-02',20,2),(3,'2024-01-03',15,2);                                                                        ;
