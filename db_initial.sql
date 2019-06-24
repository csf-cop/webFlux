-- Table Definition ----------------------------------------------
CREATE TABLE tbl_movies (
    id SERIAL PRIMARY KEY,
    movie_name character varying(200) NOT NULL UNIQUE,
    score integer
);

INSERT INTO "public"."tbl_movies"("movie_name", "score") VALUES('Polar (2019)', 64); 
INSERT INTO "public"."tbl_movies"("movie_name", "score") VALUES('Iron Man (2008)', 79); 
INSERT INTO "public"."tbl_movies"("movie_name", "score") VALUES('The Shawshank Redemption (1994)', 93); 
INSERT INTO "public"."tbl_movies"("movie_name", "score") VALUES('Forrest Gump (1994)', 83); 
INSERT INTO "public"."tbl_movies"("movie_name", "score") VALUES('Glass (2019)', 70); 