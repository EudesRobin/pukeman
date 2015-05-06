(*Transition facile commune*)

let transitionavance = ((0,"Avance"),(0,"Avance"),["Rien"],["Avance"]);;
let transitionverspacgum = ((0,"Vers PacGum"),(0,"Vers PacGum"),["Rien"],["Vers PacGum"]);;

(*Transitions moyennes communes*)

let transitionsuav = ((1,"Suit"),(0,"Avance"),["Rien"],["Avance"]);;
let transitionfuav = ((2,"Fuit"),(0,"Avance"),["Rien"],["Avance"]);;
let transitionsupm = ((1,"Suit"),(0,"Vers PacGum"),["Rien"],["Vers PacGum"]);;

(*Pacman*)

let transitionlistvide = [];;
let automatepacman = ("pm",(0,"Avance"),[(0,"Avance")],transitionlistvide);;

(*Pacman auto Facile*)

let automatepacautof = ("paf",(0,"Vers PacGum"),[(0,"Vers PacGum")],transitionlistvide);;

(*Fantome Facile*)

let automatefantomef = ("fnf",(0,"Avance"),[(0,"Avance")],transitionlistvide);;

(*Pacman auto Moyen*)

let transitionfupm = ((2,"Fuit"),(0,"Vers PacGum"),["Rien"],["Vers PacGum"]);;
let transition41pa = ((0,"Vers PacGum"),(1,"Suit"),["Voit Fantome + Vulnerable"],["Suit"]);;
let transition42pa = ((0,"Vers PacGum"),(2,"Fuit"),["Voit Fantome + Invulnerable"],["Fuit"]);;
let transition51pa = ((1,"Suit"),(1,"Suit"),["Voit Fantome + Vulnerable"],["Suit"]);;
let transition52pa = ((1,"Suit"),(2,"Fuit"),["Voit Fantome + Invulnerable"],["Fuit"]);;
let transition53pa = ((2,"Fuit"),(2,"Fuit"),["Voit Fantome + Invulnerable"],["Fuit"]);;
let transition54pa = ((2,"Fuit"),(1,"Suit"),["Voit Fantome + Vulnerable"],["Suit"]);;

let transitionlist_pam = [transitionverspacgum ; transitionsupm ; transitionfupm ;
transition41pa ; transition42pa ; transition51pa ; transition52pa ; transition53pa ; transition54pa];;

let automatepacautom = ("pam",(0,"Vers PacGum"),[(0,"Vers PacGum")],transitionlist_pam);;

(*Fantome Moyen*)

let transition31fn = ((0,"Avance"),(1,"Suit"),["Voit Pacman + Invulnerable"],["Suit"]);;
let transition32fn = ((0,"Avance"),(2,"Fuit"),["Voit Pacman + Vulnerable"],["Fuit"]);;
let transition51fn = ((1,"Suit"),(1,"Suit"),["Voit Pacman + Invulnerable"],["Suit"]);;
let transition52fn = ((1,"Suit"),(2,"Fuit"),["Voit Pacman + Vulnerable"],["Fuit"]);;
let transition53fn = ((2,"Fuit"),(2,"Fuit"),["Voit Pacman + Vulnerable"],["Fuit"]);;
let transition54fn = ((2,"Fuit"),(1,"Suit"),["Voit Pacman + Invulnerable"],["Suit"]);;

let transitionlist_fnm = [transitionavance;transitionsuav;transitionfuav;
transition31fn;transition32fn;
transition51fn;transition52fn;transition53fn;transition54fn];;

let automatefantomem = ("fnm",(0,"Avance"),[(0,"Avance")],transitionlist_fnm);;

(*Pacman auto difficile*)

let transitionfupmd = ((2,"Fuitniv2"),(0,"Vers PacGum"),["Rien"],["Vers PacGum"]);;
let transition71pa = ((0,"Vers PacGum"),(2,"Fuitniv2"),["Voit Fantome + Invulnerable"],["Fuitniv2"]);;
let transition72pa = ((1,"Suit"),(2,"Fuitniv2"),["Voit Fantome + Invulnerable"],["Fuitniv2"]);;
let transition73pa = ((2,"Fuitniv2"),(2,"Fuitniv2"),["Voit Fantome + Invulnerable"],["Fuitniv2"]);;
let transition74pa = ((2,"Fuitniv2"),(1,"Suit"),["Voit Fantome + Vulnerable"],["Suit"]);;
let transition61pa = ((0,"Vers PacGum"),(3,"Rejoint"),["A un objectif"],["Rejoint"]);;
let transition62pa = ((3,"Rejoint"),(3,"Rejoint"),["A un objectif"],["Rejoint"]);;
let transition63pa = ((3,"Rejoint"),(2,"Fuitniv2"),["Voit Fantome + Invulnerable"],["Fuitniv2"]);;
let transition64pa = ((2,"Fuitniv2"),(3,"Rejoint"),["A un objectif"],["Rejoint"]);;
let transition84pa = ((3,"Rejoint"),(0,"Vers PacGum"),["Rien"],["Vers PacGum"]);;

let transitionlist_pad = [transitionverspacgum ; transitionsupm ; transitionfupmd ; transition51pa ;
transition41pa ;transition61pa ; transition62pa ; transition63pa ; transition64pa ; transition84pa ;
transition71pa ; transition72pa ; transition73pa ; transition74pa];;

let automatepacautod = ("pad",(0,"Vers PacGum"),[(0,"Vers PacGum")],transitionlist_pad);;

(*Fantome difficile*)

let transitionfuavd = ((2,"Fuitniv2"),(0,"Avance"),["Rien"],["Avance"]);;
let transition71fn = ((0,"Avance"),(2,"Fuitniv2"),["Voit Pacman + Vulnerable"],["Fuitniv2"]);;
let transition72fn = ((1,"Suit"),(2,"Fuitniv2"),["Voit Pacman + Vulnerable"],["Fuitniv2"]);;
let transition73fn = ((2,"Fuitniv2"),(2,"Fuitniv2"),["Voit Pacman + Vulnerable"],["Fuitniv2"]);;
let transition74fn = ((2,"Fuitniv2"),(1,"Suit"),["Voit Pacman + Invulnerable"],["Suit"]);;
let transition61fn = ((0,"Avance"),(3,"Chasse"),["PM a points"],["Chasse"]);;
let transition62fn = ((3,"Chasse"),(3,"Chasse"),["PM a points"],["Chasse"]);;
let transition63fn = ((3,"Chasse"),(2,"Fuitniv2"),["Voit Pacman + Vulnerable"],["Fuitniv2"]);;
let transition64fn = ((2,"Fuitniv2"),(3,"Chasse"),["PM a points"],["Chasse"]);;
let transition65fn = ((3,"Chasse"),(1,"Suit"),["Voit Pacman + Invulnerable"],["Suit"]);;
let transition66fn = ((1,"Suit"),(3,"Chasse"),["PM a points"],["Chasse"]);;
let transition67fn = ((3,"Chasse"),(0,"Avance"),["Rien"],["Avance"]);;

let transitionlist_fnd = [transitionavance;transitionsuav;transitionfuavd;
transition31fn;transition51fn;
transition71fn;transition72fn;transition73fn;transition74fn;
transition61fn;transition62fn;transition63fn;transition64fn;transition65fn;transition66fn;transition67fn];;

let automatefantomed = ("fnd",(0,"Avance"),[(0,"Avance")],transitionlist_fnd);;

(*Construction XML*)

let comportement_pm = ("PM",automatepacman);;
let comportement_paf = ("PAF",automatepacautof);;
let comportement_pam = ("PAM",automatepacautom);;
let comportement_pad = ("PAD",automatepacautod);;
let comportement_ftf = ("FTF",automatefantomef);;
let comportement_ftm = ("FTM",automatefantomem);;
let comportement_ftd = ("FTD",automatefantomed);;
let jeu = ([comportement_pm;comportement_ftf;comportement_ftm;comportement_ftd;comportement_paf;comportement_pam;comportement_pad]);;

