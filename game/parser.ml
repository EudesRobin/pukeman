open String;;
#use "input.ml";;

let canalsorti = open_out "Parser.xml";;


let ecrirecondition condition =
output canalsorti "<Condition nature =\"" 0 20;
output canalsorti (condition) 0 (length (condition));
output canalsorti "\"/>" 0 3;
;;

let rec ecrirelistecondition cl = match cl with
|[] -> ()
|[t] -> ecrirecondition t
|t::q -> ecrirecondition t; ecrirelistecondition q;;



let ecrireaction action =
output canalsorti "<Action nature =\"" 0 17;
output canalsorti (action) 0 (length (action));
output canalsorti "\"/>" 0 3;
;;

let rec ecrireactionlist al = match al with
|[] -> ()
|[t] -> ecrireaction t
|t::q -> ecrireaction t; ecrireactionlist q;;




let ecrireetat state = let (id,name) = state in 
output canalsorti "<etat id =\"" 0 11;
output canalsorti (string_of_int id) 0 (length (string_of_int id));
output canalsorti "\" nom=\"" 0 7;
output canalsorti (name) 0 (length (name));
output canalsorti "\"/>" 0 3;;

let rec ecrireetatlist statelist = match statelist with
|[] -> ()
|[t]-> ecrireetat t
|t::q -> ecrireetat t;ecrireetatlist q;;


let ecriretransition transition =
let (etat_i,etat_f,conditions,actions) = transition in
output canalsorti "<Transition>" 0 12;
ecrireetat etat_i;
ecrireetat etat_f;
ecrirelistecondition conditions;
ecrireactionlist actions;
output canalsorti "</Transition>" 0 13;
;;

let rec ecrirelistetransition tl = match tl with
|[] -> ()
|[t] -> ecriretransition t
|t::q -> ecriretransition t; ecrirelistetransition q;;





let ecrireautomate automate =
let (name,etat_i,etat_f,tl) = automate in
output canalsorti "<Automate nom =\"" 0 16;
output canalsorti (name) 0 (length (name));
output canalsorti "\">" 0 2;
ecrireetat etat_i;
ecrireetatlist etat_f;
ecrirelistetransition tl;
output canalsorti "</Automate>" 0 11;
;;


let rec ecrirelisteautomate aul = match aul with
|[] -> ()
|[t] -> ecrireautomate t
|t::q -> ecrireautomate t; ecrirelisteautomate q;;


let ecrirecomportement comportement =
let (nature,automate) = comportement in
output canalsorti "<Comportement nature =\"" 0 23;
output canalsorti (nature) 0 (length (nature));
output canalsorti "\">" 0 2;
ecrireautomate automate;
output canalsorti "</Comportement>" 0 15;
;;

let rec ecrirelistecomportement cl = match cl with
|[] -> ()
|[t] -> ecrirecomportement t
|t::q -> ecrirecomportement t; ecrirelistecomportement q;;

let ecriretoutcomportement cpt = 
output canalsorti "<ListeComportements>" 0 20;
ecrirelistecomportement cpt;
output canalsorti "</ListeComportements>" 0 21;
;;


(**Fonction finale*)

let str = "1.0";;

let ecriretout jeu = let cl = jeu in 
output canalsorti "<?xml version =\"" 0 16;
output canalsorti (str) 0 (length (str));
output canalsorti "\"" 0 1;
output canalsorti "?>" 0 2;
output canalsorti "<Jeu>" 0 5;
ecriretoutcomportement cl;
output canalsorti "</Jeu>" 0 6
;;


(* appel de la fonction globale *)
ecriretout jeu;;

(* on ferme le fichier a ecrire *)
close_out canalsorti;;

(* ocamlc -o sortie parser.ml
   ./sortie 
   
   ou si fichiers différents :
   ocaml parser.ml *)
