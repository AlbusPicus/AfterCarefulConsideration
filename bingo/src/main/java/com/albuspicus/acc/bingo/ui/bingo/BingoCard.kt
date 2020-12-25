package com.albuspicus.acc.bingo.ui.bingo

import com.albuspicus.acc.bingo.R


data class BingoCard(val option: BingoOption, val isChecked: Boolean = false)

enum class BingoOption(val titleRes: Int) {
    REGRET_TO_INFORM(R.string.regret_to_inform),
    HI(R.string.hi),
    AFTER_CAREFUL_CONSIDERATION(R.string.after_careful_consideration),
    HOPE_FIND_SUCCESS(R.string.hope_find_success),
    MANY_QUALIFIED_CANDIDATES(R.string.many_qualified_candidates),
    HEY(R.string.hey),
    DECIDED(R.string.decided),
    LOT_OF_CANDIDATES(R.string.lots_of_candidates),
    REVIEWED_EXPERIENCE(R.string.reviewed_experience),
    DONT_REPLY(R.string.dont_reply),
    THANK_YOU(R.string.thank_you),
    ENCOURAGE_TO_KEEP_AN_EYE(R.string.encourage_to_keep_an_eye),
    FREE_CELL(R.string.free_cell),
    POSITION_FILLED(R.string.position_filled),
    IMPRESSIVE_SKILLES(R.string.impressive_skills),
    BEST_OF_LUCK(R.string.best_of_luck),
    APPRECIATE_TIME(R.string.appreciate_time),
    HARD_DECISIONS(R.string.hard_decisions),
    HELLO(R.string.hello),
    UNABLE_TO_PROVIDE_FEEDBACK(R.string.unable_to_provide_feedback),
    KEEP_IT_ON_FILE(R.string.keep_it_on_file),
    YOU_DIDNT_MATCH(R.string.you_didnt_match),
    GOOD_CANDIDATE(R.string.good_candidate),
    ADVANCE_TO_NEXT_LEVEL(R.string.advance_to_next_level),
    DEAR(R.string.dear),

}