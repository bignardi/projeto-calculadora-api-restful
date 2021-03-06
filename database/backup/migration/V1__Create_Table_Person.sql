CREATE TABLE public.person (
    id bigint NOT NULL,
    address character varying(80),
    first_name character varying(25),
    gender character varying(6),
    last_name character varying(45)
);


--
-- Name: person_id_seq; Type: SEQUENCE; Schema: public; Owner: -
--

ALTER TABLE public.person ALTER COLUMN id ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME public.person_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- Name: person person_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.person
    ADD CONSTRAINT person_pkey PRIMARY KEY (id);


--
-- PostgreSQL database dump complete
--

