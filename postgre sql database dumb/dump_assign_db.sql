--
-- PostgreSQL database dump
--

-- Dumped from database version 13.8
-- Dumped by pg_dump version 13.8

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: employee; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.employee (
    id integer NOT NULL,
    date_of_birth timestamp without time zone,
    designation character varying(255),
    emp_no character varying(255),
    first_name character varying(255),
    joined_date timestamp without time zone,
    last_name character varying(255),
    salary double precision NOT NULL,
    status character varying(255),
    deleted boolean NOT NULL
);


ALTER TABLE public.employee OWNER TO postgres;

--
-- Name: employee_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.employee_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.employee_id_seq OWNER TO postgres;

--
-- Name: employee_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.employee_id_seq OWNED BY public.employee.id;


--
-- Name: empuser; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.empuser (
    id integer NOT NULL,
    pass_word character varying(255),
    user_name character varying(255)
);


ALTER TABLE public.empuser OWNER TO postgres;

--
-- Name: empuser_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.empuser_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.empuser_id_seq OWNER TO postgres;

--
-- Name: empuser_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.empuser_id_seq OWNED BY public.empuser.id;


--
-- Name: employee id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.employee ALTER COLUMN id SET DEFAULT nextval('public.employee_id_seq'::regclass);


--
-- Name: empuser id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.empuser ALTER COLUMN id SET DEFAULT nextval('public.empuser_id_seq'::regclass);


--
-- Data for Name: employee; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.employee (id, date_of_birth, designation, emp_no, first_name, joined_date, last_name, salary, status, deleted) FROM stdin;
5	1988-01-12 00:00:00	Software Engineer	AL001	Gihan	2022-01-05 00:00:00	Perera	50000	\N	f
7	1988-01-12 00:00:00	Software Engineer	AL003	Madusanka	2022-01-05 00:00:00	Gihan	50000	\N	f
8	1988-01-12 00:00:00	Software Engineer	AL004	Gihan	2022-01-05 00:00:00	Perera	50000	\N	f
6	1988-01-12 00:00:00	Software Engineer	AL001	Madusanka	2022-01-05 00:00:00	Perera	50000	\N	t
9	1988-01-12 00:00:00	Software Engineer	AL004	Gihan	2022-01-05 00:00:00	Perera	50000	\N	t
\.


--
-- Data for Name: empuser; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.empuser (id, pass_word, user_name) FROM stdin;
1	gihan@123	gihan
\.


--
-- Name: employee_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.employee_id_seq', 9, true);


--
-- Name: empuser_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.empuser_id_seq', 1, true);


--
-- Name: employee employee_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.employee
    ADD CONSTRAINT employee_pkey PRIMARY KEY (id);


--
-- Name: empuser empuser_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.empuser
    ADD CONSTRAINT empuser_pkey PRIMARY KEY (id);


--
-- PostgreSQL database dump complete
--

