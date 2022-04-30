package com.csye7200.application.services;

import org.apache.sling.commons.json.JSONException;
import org.apache.sling.commons.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class SpotifyServiceTest {

    @Test
    public void getTrackNameTest1(){
        try {
        SpotifyService ss = new SpotifyService();
            JSONObject jo = new JSONObject("{\n" +
                    "    \"added_at\" : \"2022-04-01T11:11:54Z\",\n" +
                    "    \"added_by\" : {\n" +
                    "      \"external_urls\" : {\n" +
                    "        \"spotify\" : \"https://open.spotify.com/user/\"\n" +
                    "      },\n" +
                    "      \"href\" : \"https://api.spotify.com/v1/users/\",\n" +
                    "      \"id\" : \"\",\n" +
                    "      \"type\" : \"user\",\n" +
                    "      \"uri\" : \"spotify:user:\"\n" +
                    "    },\n" +
                    "    \"is_local\" : false,\n" +
                    "    \"primary_color\" : null,\n" +
                    "    \"track\" : {\n" +
                    "      \"album\" : {\n" +
                    "        \"album_type\" : \"album\",\n" +
                    "        \"artists\" : [ {\n" +
                    "          \"external_urls\" : {\n" +
                    "            \"spotify\" : \"https://open.spotify.com/artist/4yvcSjfu4PC0CYQyLy4wSq\"\n" +
                    "          },\n" +
                    "          \"href\" : \"https://api.spotify.com/v1/artists/4yvcSjfu4PC0CYQyLy4wSq\",\n" +
                    "          \"id\" : \"4yvcSjfu4PC0CYQyLy4wSq\",\n" +
                    "          \"name\" : \"Glass Animals\",\n" +
                    "          \"type\" : \"artist\",\n" +
                    "          \"uri\" : \"spotify:artist:4yvcSjfu4PC0CYQyLy4wSq\"\n" +
                    "        } ],\n" +
                    "        \"available_markets\" : [ \"AD\", \"AE\", \"AG\", \"AL\", \"AM\", \"AO\", \"AR\", \"AT\", \"AU\", \"AZ\", \"BA\", \"BB\", \"BD\", \"BE\", \"BF\", \"BG\", \"BH\", \"BI\", \"BJ\", \"BN\", \"BO\", \"BR\", \"BS\", \"BT\", \"BW\", \"BY\", \"BZ\", \"CA\", \"CD\", \"CG\", \"CH\", \"CI\", \"CL\", \"CM\", \"CO\", \"CR\", \"CV\", \"CW\", \"CY\", \"CZ\", \"DE\", \"DJ\", \"DK\", \"DM\", \"DO\", \"DZ\", \"EC\", \"EE\", \"EG\", \"ES\", \"FI\", \"FJ\", \"FM\", \"FR\", \"GA\", \"GB\", \"GD\", \"GE\", \"GH\", \"GM\", \"GN\", \"GQ\", \"GR\", \"GT\", \"GW\", \"GY\", \"HK\", \"HN\", \"HR\", \"HT\", \"HU\", \"ID\", \"IE\", \"IL\", \"IN\", \"IQ\", \"IS\", \"IT\", \"JM\", \"JO\", \"JP\", \"KE\", \"KG\", \"KH\", \"KI\", \"KM\", \"KN\", \"KR\", \"KW\", \"KZ\", \"LA\", \"LB\", \"LC\", \"LI\", \"LK\", \"LR\", \"LS\", \"LT\", \"LU\", \"LV\", \"LY\", \"MA\", \"MC\", \"MD\", \"ME\", \"MG\", \"MH\", \"MK\", \"ML\", \"MN\", \"MO\", \"MR\", \"MT\", \"MU\", \"MV\", \"MW\", \"MX\", \"MY\", \"MZ\", \"NA\", \"NE\", \"NG\", \"NI\", \"NL\", \"NO\", \"NP\", \"NR\", \"NZ\", \"OM\", \"PA\", \"PE\", \"PG\", \"PH\", \"PK\", \"PL\", \"PS\", \"PT\", \"PW\", \"PY\", \"QA\", \"RO\", \"RS\", \"RU\", \"RW\", \"SA\", \"SB\", \"SC\", \"SE\", \"SG\", \"SI\", \"SK\", \"SL\", \"SM\", \"SN\", \"SR\", \"ST\", \"SV\", \"SZ\", \"TD\", \"TG\", \"TH\", \"TJ\", \"TL\", \"TN\", \"TO\", \"TR\", \"TT\", \"TV\", \"TW\", \"TZ\", \"UA\", \"UG\", \"US\", \"UY\", \"UZ\", \"VC\", \"VE\", \"VN\", \"VU\", \"WS\", \"XK\", \"ZA\", \"ZM\", \"ZW\" ],\n" +
                    "        \"external_urls\" : {\n" +
                    "          \"spotify\" : \"https://open.spotify.com/album/0KTj6k94XZh0c6IEMfxeWV\"\n" +
                    "        },\n" +
                    "        \"href\" : \"https://api.spotify.com/v1/albums/0KTj6k94XZh0c6IEMfxeWV\",\n" +
                    "        \"id\" : \"0KTj6k94XZh0c6IEMfxeWV\",\n" +
                    "        \"images\" : [ {\n" +
                    "          \"height\" : 640,\n" +
                    "          \"url\" : \"https://i.scdn.co/image/ab67616d0000b2739e495fb707973f3390850eea\",\n" +
                    "          \"width\" : 640\n" +
                    "        }, {\n" +
                    "          \"height\" : 300,\n" +
                    "          \"url\" : \"https://i.scdn.co/image/ab67616d00001e029e495fb707973f3390850eea\",\n" +
                    "          \"width\" : 300\n" +
                    "        }, {\n" +
                    "          \"height\" : 64,\n" +
                    "          \"url\" : \"https://i.scdn.co/image/ab67616d000048519e495fb707973f3390850eea\",\n" +
                    "          \"width\" : 64\n" +
                    "        } ],\n" +
                    "        \"name\" : \"Dreamland (+ Bonus Levels)\",\n" +
                    "        \"release_date\" : \"2020-08-06\",\n" +
                    "        \"release_date_precision\" : \"day\",\n" +
                    "        \"total_tracks\" : 18,\n" +
                    "        \"type\" : \"album\",\n" +
                    "        \"uri\" : \"spotify:album:0KTj6k94XZh0c6IEMfxeWV\"\n" +
                    "      },\n" +
                    "      \"artists\" : [ {\n" +
                    "        \"external_urls\" : {\n" +
                    "          \"spotify\" : \"https://open.spotify.com/artist/4yvcSjfu4PC0CYQyLy4wSq\"\n" +
                    "        },\n" +
                    "        \"href\" : \"https://api.spotify.com/v1/artists/4yvcSjfu4PC0CYQyLy4wSq\",\n" +
                    "        \"id\" : \"4yvcSjfu4PC0CYQyLy4wSq\",\n" +
                    "        \"name\" : \"Glass Animals\",\n" +
                    "        \"type\" : \"artist\",\n" +
                    "        \"uri\" : \"spotify:artist:4yvcSjfu4PC0CYQyLy4wSq\"\n" +
                    "      } ],\n" +
                    "      \"available_markets\" : [ \"AD\", \"AE\", \"AG\", \"AL\", \"AM\", \"AO\", \"AR\", \"AT\", \"AU\", \"AZ\", \"BA\", \"BB\", \"BD\", \"BE\", \"BF\", \"BG\", \"BH\", \"BI\", \"BJ\", \"BN\", \"BO\", \"BR\", \"BS\", \"BT\", \"BW\", \"BY\", \"BZ\", \"CA\", \"CD\", \"CG\", \"CH\", \"CI\", \"CL\", \"CM\", \"CO\", \"CR\", \"CV\", \"CW\", \"CY\", \"CZ\", \"DE\", \"DJ\", \"DK\", \"DM\", \"DO\", \"DZ\", \"EC\", \"EE\", \"EG\", \"ES\", \"FI\", \"FJ\", \"FM\", \"FR\", \"GA\", \"GB\", \"GD\", \"GE\", \"GH\", \"GM\", \"GN\", \"GQ\", \"GR\", \"GT\", \"GW\", \"GY\", \"HK\", \"HN\", \"HR\", \"HT\", \"HU\", \"ID\", \"IE\", \"IL\", \"IN\", \"IQ\", \"IS\", \"IT\", \"JM\", \"JO\", \"JP\", \"KE\", \"KG\", \"KH\", \"KI\", \"KM\", \"KN\", \"KR\", \"KW\", \"KZ\", \"LA\", \"LB\", \"LC\", \"LI\", \"LK\", \"LR\", \"LS\", \"LT\", \"LU\", \"LV\", \"LY\", \"MA\", \"MC\", \"MD\", \"ME\", \"MG\", \"MH\", \"MK\", \"ML\", \"MN\", \"MO\", \"MR\", \"MT\", \"MU\", \"MV\", \"MW\", \"MX\", \"MY\", \"MZ\", \"NA\", \"NE\", \"NG\", \"NI\", \"NL\", \"NO\", \"NP\", \"NR\", \"NZ\", \"OM\", \"PA\", \"PE\", \"PG\", \"PH\", \"PK\", \"PL\", \"PS\", \"PT\", \"PW\", \"PY\", \"QA\", \"RO\", \"RS\", \"RU\", \"RW\", \"SA\", \"SB\", \"SC\", \"SE\", \"SG\", \"SI\", \"SK\", \"SL\", \"SM\", \"SN\", \"SR\", \"ST\", \"SV\", \"SZ\", \"TD\", \"TG\", \"TH\", \"TJ\", \"TL\", \"TN\", \"TO\", \"TR\", \"TT\", \"TV\", \"TW\", \"TZ\", \"UA\", \"UG\", \"US\", \"UY\", \"UZ\", \"VC\", \"VE\", \"VN\", \"VU\", \"WS\", \"XK\", \"ZA\", \"ZM\", \"ZW\" ],\n" +
                    "      \"disc_number\" : 1,\n" +
                    "      \"duration_ms\" : 238805,\n" +
                    "      \"episode\" : false,\n" +
                    "      \"explicit\" : false,\n" +
                    "      \"external_ids\" : {\n" +
                    "        \"isrc\" : \"GBUM72000433\"\n" +
                    "      },\n" +
                    "      \"external_urls\" : {\n" +
                    "        \"spotify\" : \"https://open.spotify.com/track/02MWAaffLxlfxAUY7c5dvx\"\n" +
                    "      },\n" +
                    "      \"href\" : \"https://api.spotify.com/v1/tracks/02MWAaffLxlfxAUY7c5dvx\",\n" +
                    "      \"id\" : \"02MWAaffLxlfxAUY7c5dvx\",\n" +
                    "      \"is_local\" : false,\n" +
                    "      \"name\" : \"Heat Waves\",\n" +
                    "      \"popularity\" : 96,\n" +
                    "      \"preview_url\" : null,\n" +
                    "      \"track\" : true,\n" +
                    "      \"track_number\" : 14,\n" +
                    "      \"type\" : \"track\",\n" +
                    "      \"uri\" : \"spotify:track:02MWAaffLxlfxAUY7c5dvx\"\n" +
                    "    },\n" +
                    "    \"video_thumbnail\" : {\n" +
                    "      \"url\" : null\n" +
                    "    }\n" +
                    "  }");
            assertEquals("Heat Waves",ss.getTrackName(jo));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getTrackNameTest2(){
        try {
            SpotifyService ss = new SpotifyService();
            JSONObject jo = new JSONObject("{\n" +
                    "    \"added_at\" : \"2022-04-01T11:11:54Z\",\n" +
                    "    \"added_by\" : {\n" +
                    "      \"external_urls\" : {\n" +
                    "        \"spotify\" : \"https://open.spotify.com/user/\"\n" +
                    "      },\n" +
                    "      \"href\" : \"https://api.spotify.com/v1/users/\",\n" +
                    "      \"id\" : \"\",\n" +
                    "      \"type\" : \"user\",\n" +
                    "      \"uri\" : \"spotify:user:\"\n" +
                    "    },\n" +
                    "    \"is_local\" : false,\n" +
                    "    \"primary_color\" : null,\n" +
                    "    \"track\" : {\n" +
                    "      \"album\" : {\n" +
                    "        \"album_type\" : \"album\",\n" +
                    "        \"artists\" : [ {\n" +
                    "          \"external_urls\" : {\n" +
                    "            \"spotify\" : \"https://open.spotify.com/artist/4yvcSjfu4PC0CYQyLy4wSq\"\n" +
                    "          },\n" +
                    "          \"href\" : \"https://api.spotify.com/v1/artists/4yvcSjfu4PC0CYQyLy4wSq\",\n" +
                    "          \"id\" : \"4yvcSjfu4PC0CYQyLy4wSq\",\n" +
                    "          \"name\" : \"Glass Animals\",\n" +
                    "          \"type\" : \"artist\",\n" +
                    "          \"uri\" : \"spotify:artist:4yvcSjfu4PC0CYQyLy4wSq\"\n" +
                    "        } ],\n" +
                    "        \"available_markets\" : [ \"AD\", \"AE\", \"AG\", \"AL\", \"AM\", \"AO\", \"AR\", \"AT\", \"AU\", \"AZ\", \"BA\", \"BB\", \"BD\", \"BE\", \"BF\", \"BG\", \"BH\", \"BI\", \"BJ\", \"BN\", \"BO\", \"BR\", \"BS\", \"BT\", \"BW\", \"BY\", \"BZ\", \"CA\", \"CD\", \"CG\", \"CH\", \"CI\", \"CL\", \"CM\", \"CO\", \"CR\", \"CV\", \"CW\", \"CY\", \"CZ\", \"DE\", \"DJ\", \"DK\", \"DM\", \"DO\", \"DZ\", \"EC\", \"EE\", \"EG\", \"ES\", \"FI\", \"FJ\", \"FM\", \"FR\", \"GA\", \"GB\", \"GD\", \"GE\", \"GH\", \"GM\", \"GN\", \"GQ\", \"GR\", \"GT\", \"GW\", \"GY\", \"HK\", \"HN\", \"HR\", \"HT\", \"HU\", \"ID\", \"IE\", \"IL\", \"IN\", \"IQ\", \"IS\", \"IT\", \"JM\", \"JO\", \"JP\", \"KE\", \"KG\", \"KH\", \"KI\", \"KM\", \"KN\", \"KR\", \"KW\", \"KZ\", \"LA\", \"LB\", \"LC\", \"LI\", \"LK\", \"LR\", \"LS\", \"LT\", \"LU\", \"LV\", \"LY\", \"MA\", \"MC\", \"MD\", \"ME\", \"MG\", \"MH\", \"MK\", \"ML\", \"MN\", \"MO\", \"MR\", \"MT\", \"MU\", \"MV\", \"MW\", \"MX\", \"MY\", \"MZ\", \"NA\", \"NE\", \"NG\", \"NI\", \"NL\", \"NO\", \"NP\", \"NR\", \"NZ\", \"OM\", \"PA\", \"PE\", \"PG\", \"PH\", \"PK\", \"PL\", \"PS\", \"PT\", \"PW\", \"PY\", \"QA\", \"RO\", \"RS\", \"RU\", \"RW\", \"SA\", \"SB\", \"SC\", \"SE\", \"SG\", \"SI\", \"SK\", \"SL\", \"SM\", \"SN\", \"SR\", \"ST\", \"SV\", \"SZ\", \"TD\", \"TG\", \"TH\", \"TJ\", \"TL\", \"TN\", \"TO\", \"TR\", \"TT\", \"TV\", \"TW\", \"TZ\", \"UA\", \"UG\", \"US\", \"UY\", \"UZ\", \"VC\", \"VE\", \"VN\", \"VU\", \"WS\", \"XK\", \"ZA\", \"ZM\", \"ZW\" ],\n" +
                    "        \"external_urls\" : {\n" +
                    "          \"spotify\" : \"https://open.spotify.com/album/0KTj6k94XZh0c6IEMfxeWV\"\n" +
                    "        },\n" +
                    "        \"href\" : \"https://api.spotify.com/v1/albums/0KTj6k94XZh0c6IEMfxeWV\",\n" +
                    "        \"id\" : \"0KTj6k94XZh0c6IEMfxeWV\",\n" +
                    "        \"images\" : [ {\n" +
                    "          \"height\" : 640,\n" +
                    "          \"url\" : \"https://i.scdn.co/image/ab67616d0000b2739e495fb707973f3390850eea\",\n" +
                    "          \"width\" : 640\n" +
                    "        }, {\n" +
                    "          \"height\" : 300,\n" +
                    "          \"url\" : \"https://i.scdn.co/image/ab67616d00001e029e495fb707973f3390850eea\",\n" +
                    "          \"width\" : 300\n" +
                    "        }, {\n" +
                    "          \"height\" : 64,\n" +
                    "          \"url\" : \"https://i.scdn.co/image/ab67616d000048519e495fb707973f3390850eea\",\n" +
                    "          \"width\" : 64\n" +
                    "        } ],\n" +
                    "        \"name\" : \"Dreamland (+ Bonus Levels)\",\n" +
                    "        \"release_date\" : \"2020-08-06\",\n" +
                    "        \"release_date_precision\" : \"day\",\n" +
                    "        \"total_tracks\" : 18,\n" +
                    "        \"type\" : \"album\",\n" +
                    "        \"uri\" : \"spotify:album:0KTj6k94XZh0c6IEMfxeWV\"\n" +
                    "      },\n" +
                    "      \"artists\" : [ {\n" +
                    "        \"external_urls\" : {\n" +
                    "          \"spotify\" : \"https://open.spotify.com/artist/4yvcSjfu4PC0CYQyLy4wSq\"\n" +
                    "        },\n" +
                    "        \"href\" : \"https://api.spotify.com/v1/artists/4yvcSjfu4PC0CYQyLy4wSq\",\n" +
                    "        \"id\" : \"4yvcSjfu4PC0CYQyLy4wSq\",\n" +
                    "        \"name\" : \"Glass Animals\",\n" +
                    "        \"type\" : \"artist\",\n" +
                    "        \"uri\" : \"spotify:artist:4yvcSjfu4PC0CYQyLy4wSq\"\n" +
                    "      } ],\n" +
                    "      \"available_markets\" : [ \"AD\", \"AE\", \"AG\", \"AL\", \"AM\", \"AO\", \"AR\", \"AT\", \"AU\", \"AZ\", \"BA\", \"BB\", \"BD\", \"BE\", \"BF\", \"BG\", \"BH\", \"BI\", \"BJ\", \"BN\", \"BO\", \"BR\", \"BS\", \"BT\", \"BW\", \"BY\", \"BZ\", \"CA\", \"CD\", \"CG\", \"CH\", \"CI\", \"CL\", \"CM\", \"CO\", \"CR\", \"CV\", \"CW\", \"CY\", \"CZ\", \"DE\", \"DJ\", \"DK\", \"DM\", \"DO\", \"DZ\", \"EC\", \"EE\", \"EG\", \"ES\", \"FI\", \"FJ\", \"FM\", \"FR\", \"GA\", \"GB\", \"GD\", \"GE\", \"GH\", \"GM\", \"GN\", \"GQ\", \"GR\", \"GT\", \"GW\", \"GY\", \"HK\", \"HN\", \"HR\", \"HT\", \"HU\", \"ID\", \"IE\", \"IL\", \"IN\", \"IQ\", \"IS\", \"IT\", \"JM\", \"JO\", \"JP\", \"KE\", \"KG\", \"KH\", \"KI\", \"KM\", \"KN\", \"KR\", \"KW\", \"KZ\", \"LA\", \"LB\", \"LC\", \"LI\", \"LK\", \"LR\", \"LS\", \"LT\", \"LU\", \"LV\", \"LY\", \"MA\", \"MC\", \"MD\", \"ME\", \"MG\", \"MH\", \"MK\", \"ML\", \"MN\", \"MO\", \"MR\", \"MT\", \"MU\", \"MV\", \"MW\", \"MX\", \"MY\", \"MZ\", \"NA\", \"NE\", \"NG\", \"NI\", \"NL\", \"NO\", \"NP\", \"NR\", \"NZ\", \"OM\", \"PA\", \"PE\", \"PG\", \"PH\", \"PK\", \"PL\", \"PS\", \"PT\", \"PW\", \"PY\", \"QA\", \"RO\", \"RS\", \"RU\", \"RW\", \"SA\", \"SB\", \"SC\", \"SE\", \"SG\", \"SI\", \"SK\", \"SL\", \"SM\", \"SN\", \"SR\", \"ST\", \"SV\", \"SZ\", \"TD\", \"TG\", \"TH\", \"TJ\", \"TL\", \"TN\", \"TO\", \"TR\", \"TT\", \"TV\", \"TW\", \"TZ\", \"UA\", \"UG\", \"US\", \"UY\", \"UZ\", \"VC\", \"VE\", \"VN\", \"VU\", \"WS\", \"XK\", \"ZA\", \"ZM\", \"ZW\" ],\n" +
                    "      \"disc_number\" : 1,\n" +
                    "      \"duration_ms\" : 238805,\n" +
                    "      \"episode\" : false,\n" +
                    "      \"explicit\" : false,\n" +
                    "      \"external_ids\" : {\n" +
                    "        \"isrc\" : \"GBUM72000433\"\n" +
                    "      },\n" +
                    "      \"external_urls\" : {\n" +
                    "        \"spotify\" : \"https://open.spotify.com/track/02MWAaffLxlfxAUY7c5dvx\"\n" +
                    "      },\n" +
                    "      \"href\" : \"https://api.spotify.com/v1/tracks/02MWAaffLxlfxAUY7c5dvx\",\n" +
                    "      \"id\" : \"02MWAaffLxlfxAUY7c5dvx\",\n" +
                    "      \"is_local\" : false,\n" +
                    "      \"name\" : \"In the End\",\n" +
                    "      \"popularity\" : 96,\n" +
                    "      \"preview_url\" : null,\n" +
                    "      \"track\" : true,\n" +
                    "      \"track_number\" : 14,\n" +
                    "      \"type\" : \"track\",\n" +
                    "      \"uri\" : \"spotify:track:02MWAaffLxlfxAUY7c5dvx\"\n" +
                    "    },\n" +
                    "    \"video_thumbnail\" : {\n" +
                    "      \"url\" : null\n" +
                    "    }\n" +
                    "  }");
            assertEquals("In the End",ss.getTrackName(jo));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getTrackNameTest3(){
        try {
            SpotifyService ss = new SpotifyService();
            JSONObject jo = new JSONObject("{\n" +
                    "    \"added_at\" : \"2022-04-01T11:11:54Z\",\n" +
                    "    \"added_by\" : {\n" +
                    "      \"external_urls\" : {\n" +
                    "        \"spotify\" : \"https://open.spotify.com/user/\"\n" +
                    "      },\n" +
                    "      \"href\" : \"https://api.spotify.com/v1/users/\",\n" +
                    "      \"id\" : \"\",\n" +
                    "      \"type\" : \"user\",\n" +
                    "      \"uri\" : \"spotify:user:\"\n" +
                    "    },\n" +
                    "    \"is_local\" : false,\n" +
                    "    \"primary_color\" : null,\n" +
                    "    \"track\" : {\n" +
                    "      \"album\" : {\n" +
                    "        \"album_type\" : \"album\",\n" +
                    "        \"artists\" : [ {\n" +
                    "          \"external_urls\" : {\n" +
                    "            \"spotify\" : \"https://open.spotify.com/artist/4yvcSjfu4PC0CYQyLy4wSq\"\n" +
                    "          },\n" +
                    "          \"href\" : \"https://api.spotify.com/v1/artists/4yvcSjfu4PC0CYQyLy4wSq\",\n" +
                    "          \"id\" : \"4yvcSjfu4PC0CYQyLy4wSq\",\n" +
                    "          \"name\" : \"Glass Animals\",\n" +
                    "          \"type\" : \"artist\",\n" +
                    "          \"uri\" : \"spotify:artist:4yvcSjfu4PC0CYQyLy4wSq\"\n" +
                    "        } ],\n" +
                    "        \"available_markets\" : [ \"AD\", \"AE\", \"AG\", \"AL\", \"AM\", \"AO\", \"AR\", \"AT\", \"AU\", \"AZ\", \"BA\", \"BB\", \"BD\", \"BE\", \"BF\", \"BG\", \"BH\", \"BI\", \"BJ\", \"BN\", \"BO\", \"BR\", \"BS\", \"BT\", \"BW\", \"BY\", \"BZ\", \"CA\", \"CD\", \"CG\", \"CH\", \"CI\", \"CL\", \"CM\", \"CO\", \"CR\", \"CV\", \"CW\", \"CY\", \"CZ\", \"DE\", \"DJ\", \"DK\", \"DM\", \"DO\", \"DZ\", \"EC\", \"EE\", \"EG\", \"ES\", \"FI\", \"FJ\", \"FM\", \"FR\", \"GA\", \"GB\", \"GD\", \"GE\", \"GH\", \"GM\", \"GN\", \"GQ\", \"GR\", \"GT\", \"GW\", \"GY\", \"HK\", \"HN\", \"HR\", \"HT\", \"HU\", \"ID\", \"IE\", \"IL\", \"IN\", \"IQ\", \"IS\", \"IT\", \"JM\", \"JO\", \"JP\", \"KE\", \"KG\", \"KH\", \"KI\", \"KM\", \"KN\", \"KR\", \"KW\", \"KZ\", \"LA\", \"LB\", \"LC\", \"LI\", \"LK\", \"LR\", \"LS\", \"LT\", \"LU\", \"LV\", \"LY\", \"MA\", \"MC\", \"MD\", \"ME\", \"MG\", \"MH\", \"MK\", \"ML\", \"MN\", \"MO\", \"MR\", \"MT\", \"MU\", \"MV\", \"MW\", \"MX\", \"MY\", \"MZ\", \"NA\", \"NE\", \"NG\", \"NI\", \"NL\", \"NO\", \"NP\", \"NR\", \"NZ\", \"OM\", \"PA\", \"PE\", \"PG\", \"PH\", \"PK\", \"PL\", \"PS\", \"PT\", \"PW\", \"PY\", \"QA\", \"RO\", \"RS\", \"RU\", \"RW\", \"SA\", \"SB\", \"SC\", \"SE\", \"SG\", \"SI\", \"SK\", \"SL\", \"SM\", \"SN\", \"SR\", \"ST\", \"SV\", \"SZ\", \"TD\", \"TG\", \"TH\", \"TJ\", \"TL\", \"TN\", \"TO\", \"TR\", \"TT\", \"TV\", \"TW\", \"TZ\", \"UA\", \"UG\", \"US\", \"UY\", \"UZ\", \"VC\", \"VE\", \"VN\", \"VU\", \"WS\", \"XK\", \"ZA\", \"ZM\", \"ZW\" ],\n" +
                    "        \"external_urls\" : {\n" +
                    "          \"spotify\" : \"https://open.spotify.com/album/0KTj6k94XZh0c6IEMfxeWV\"\n" +
                    "        },\n" +
                    "        \"href\" : \"https://api.spotify.com/v1/albums/0KTj6k94XZh0c6IEMfxeWV\",\n" +
                    "        \"id\" : \"0KTj6k94XZh0c6IEMfxeWV\",\n" +
                    "        \"images\" : [ {\n" +
                    "          \"height\" : 640,\n" +
                    "          \"url\" : \"https://i.scdn.co/image/ab67616d0000b2739e495fb707973f3390850eea\",\n" +
                    "          \"width\" : 640\n" +
                    "        }, {\n" +
                    "          \"height\" : 300,\n" +
                    "          \"url\" : \"https://i.scdn.co/image/ab67616d00001e029e495fb707973f3390850eea\",\n" +
                    "          \"width\" : 300\n" +
                    "        }, {\n" +
                    "          \"height\" : 64,\n" +
                    "          \"url\" : \"https://i.scdn.co/image/ab67616d000048519e495fb707973f3390850eea\",\n" +
                    "          \"width\" : 64\n" +
                    "        } ],\n" +
                    "        \"name\" : \"Dreamland (+ Bonus Levels)\",\n" +
                    "        \"release_date\" : \"2020-08-06\",\n" +
                    "        \"release_date_precision\" : \"day\",\n" +
                    "        \"total_tracks\" : 18,\n" +
                    "        \"type\" : \"album\",\n" +
                    "        \"uri\" : \"spotify:album:0KTj6k94XZh0c6IEMfxeWV\"\n" +
                    "      },\n" +
                    "      \"artists\" : [ {\n" +
                    "        \"external_urls\" : {\n" +
                    "          \"spotify\" : \"https://open.spotify.com/artist/4yvcSjfu4PC0CYQyLy4wSq\"\n" +
                    "        },\n" +
                    "        \"href\" : \"https://api.spotify.com/v1/artists/4yvcSjfu4PC0CYQyLy4wSq\",\n" +
                    "        \"id\" : \"4yvcSjfu4PC0CYQyLy4wSq\",\n" +
                    "        \"name\" : \"Glass Animals\",\n" +
                    "        \"type\" : \"artist\",\n" +
                    "        \"uri\" : \"spotify:artist:4yvcSjfu4PC0CYQyLy4wSq\"\n" +
                    "      } ],\n" +
                    "      \"available_markets\" : [ \"AD\", \"AE\", \"AG\", \"AL\", \"AM\", \"AO\", \"AR\", \"AT\", \"AU\", \"AZ\", \"BA\", \"BB\", \"BD\", \"BE\", \"BF\", \"BG\", \"BH\", \"BI\", \"BJ\", \"BN\", \"BO\", \"BR\", \"BS\", \"BT\", \"BW\", \"BY\", \"BZ\", \"CA\", \"CD\", \"CG\", \"CH\", \"CI\", \"CL\", \"CM\", \"CO\", \"CR\", \"CV\", \"CW\", \"CY\", \"CZ\", \"DE\", \"DJ\", \"DK\", \"DM\", \"DO\", \"DZ\", \"EC\", \"EE\", \"EG\", \"ES\", \"FI\", \"FJ\", \"FM\", \"FR\", \"GA\", \"GB\", \"GD\", \"GE\", \"GH\", \"GM\", \"GN\", \"GQ\", \"GR\", \"GT\", \"GW\", \"GY\", \"HK\", \"HN\", \"HR\", \"HT\", \"HU\", \"ID\", \"IE\", \"IL\", \"IN\", \"IQ\", \"IS\", \"IT\", \"JM\", \"JO\", \"JP\", \"KE\", \"KG\", \"KH\", \"KI\", \"KM\", \"KN\", \"KR\", \"KW\", \"KZ\", \"LA\", \"LB\", \"LC\", \"LI\", \"LK\", \"LR\", \"LS\", \"LT\", \"LU\", \"LV\", \"LY\", \"MA\", \"MC\", \"MD\", \"ME\", \"MG\", \"MH\", \"MK\", \"ML\", \"MN\", \"MO\", \"MR\", \"MT\", \"MU\", \"MV\", \"MW\", \"MX\", \"MY\", \"MZ\", \"NA\", \"NE\", \"NG\", \"NI\", \"NL\", \"NO\", \"NP\", \"NR\", \"NZ\", \"OM\", \"PA\", \"PE\", \"PG\", \"PH\", \"PK\", \"PL\", \"PS\", \"PT\", \"PW\", \"PY\", \"QA\", \"RO\", \"RS\", \"RU\", \"RW\", \"SA\", \"SB\", \"SC\", \"SE\", \"SG\", \"SI\", \"SK\", \"SL\", \"SM\", \"SN\", \"SR\", \"ST\", \"SV\", \"SZ\", \"TD\", \"TG\", \"TH\", \"TJ\", \"TL\", \"TN\", \"TO\", \"TR\", \"TT\", \"TV\", \"TW\", \"TZ\", \"UA\", \"UG\", \"US\", \"UY\", \"UZ\", \"VC\", \"VE\", \"VN\", \"VU\", \"WS\", \"XK\", \"ZA\", \"ZM\", \"ZW\" ],\n" +
                    "      \"disc_number\" : 1,\n" +
                    "      \"duration_ms\" : 238805,\n" +
                    "      \"episode\" : false,\n" +
                    "      \"explicit\" : false,\n" +
                    "      \"external_ids\" : {\n" +
                    "        \"isrc\" : \"GBUM72000433\"\n" +
                    "      },\n" +
                    "      \"external_urls\" : {\n" +
                    "        \"spotify\" : \"https://open.spotify.com/track/02MWAaffLxlfxAUY7c5dvx\"\n" +
                    "      },\n" +
                    "      \"href\" : \"https://api.spotify.com/v1/tracks/02MWAaffLxlfxAUY7c5dvx\",\n" +
                    "      \"id\" : \"02MWAaffLxlfxAUY7c5dvx\",\n" +
                    "      \"is_local\" : false,\n" +
                    "      \"name\" : \"Numb\",\n" +
                    "      \"popularity\" : 96,\n" +
                    "      \"preview_url\" : null,\n" +
                    "      \"track\" : true,\n" +
                    "      \"track_number\" : 14,\n" +
                    "      \"type\" : \"track\",\n" +
                    "      \"uri\" : \"spotify:track:02MWAaffLxlfxAUY7c5dvx\"\n" +
                    "    },\n" +
                    "    \"video_thumbnail\" : {\n" +
                    "      \"url\" : null\n" +
                    "    }\n" +
                    "  }");
            assertEquals("Numb",ss.getTrackName(jo));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getArtistNameTest1(){

        try {
            SpotifyService ss = new SpotifyService();
            JSONObject jo = new JSONObject("{\n" +
                    "    \"added_at\" : \"2022-04-01T11:11:54Z\",\n" +
                    "    \"added_by\" : {\n" +
                    "      \"external_urls\" : {\n" +
                    "        \"spotify\" : \"https://open.spotify.com/user/\"\n" +
                    "      },\n" +
                    "      \"href\" : \"https://api.spotify.com/v1/users/\",\n" +
                    "      \"id\" : \"\",\n" +
                    "      \"type\" : \"user\",\n" +
                    "      \"uri\" : \"spotify:user:\"\n" +
                    "    },\n" +
                    "    \"is_local\" : false,\n" +
                    "    \"primary_color\" : null,\n" +
                    "    \"track\" : {\n" +
                    "      \"album\" : {\n" +
                    "        \"album_type\" : \"album\",\n" +
                    "        \"artists\" : [ {\n" +
                    "          \"external_urls\" : {\n" +
                    "            \"spotify\" : \"https://open.spotify.com/artist/4yvcSjfu4PC0CYQyLy4wSq\"\n" +
                    "          },\n" +
                    "          \"href\" : \"https://api.spotify.com/v1/artists/4yvcSjfu4PC0CYQyLy4wSq\",\n" +
                    "          \"id\" : \"4yvcSjfu4PC0CYQyLy4wSq\",\n" +
                    "          \"name\" : \"Glass Animals\",\n" +
                    "          \"type\" : \"artist\",\n" +
                    "          \"uri\" : \"spotify:artist:4yvcSjfu4PC0CYQyLy4wSq\"\n" +
                    "        } ],\n" +
                    "        \"available_markets\" : [ \"AD\", \"AE\", \"AG\", \"AL\", \"AM\", \"AO\", \"AR\", \"AT\", \"AU\", \"AZ\", \"BA\", \"BB\", \"BD\", \"BE\", \"BF\", \"BG\", \"BH\", \"BI\", \"BJ\", \"BN\", \"BO\", \"BR\", \"BS\", \"BT\", \"BW\", \"BY\", \"BZ\", \"CA\", \"CD\", \"CG\", \"CH\", \"CI\", \"CL\", \"CM\", \"CO\", \"CR\", \"CV\", \"CW\", \"CY\", \"CZ\", \"DE\", \"DJ\", \"DK\", \"DM\", \"DO\", \"DZ\", \"EC\", \"EE\", \"EG\", \"ES\", \"FI\", \"FJ\", \"FM\", \"FR\", \"GA\", \"GB\", \"GD\", \"GE\", \"GH\", \"GM\", \"GN\", \"GQ\", \"GR\", \"GT\", \"GW\", \"GY\", \"HK\", \"HN\", \"HR\", \"HT\", \"HU\", \"ID\", \"IE\", \"IL\", \"IN\", \"IQ\", \"IS\", \"IT\", \"JM\", \"JO\", \"JP\", \"KE\", \"KG\", \"KH\", \"KI\", \"KM\", \"KN\", \"KR\", \"KW\", \"KZ\", \"LA\", \"LB\", \"LC\", \"LI\", \"LK\", \"LR\", \"LS\", \"LT\", \"LU\", \"LV\", \"LY\", \"MA\", \"MC\", \"MD\", \"ME\", \"MG\", \"MH\", \"MK\", \"ML\", \"MN\", \"MO\", \"MR\", \"MT\", \"MU\", \"MV\", \"MW\", \"MX\", \"MY\", \"MZ\", \"NA\", \"NE\", \"NG\", \"NI\", \"NL\", \"NO\", \"NP\", \"NR\", \"NZ\", \"OM\", \"PA\", \"PE\", \"PG\", \"PH\", \"PK\", \"PL\", \"PS\", \"PT\", \"PW\", \"PY\", \"QA\", \"RO\", \"RS\", \"RU\", \"RW\", \"SA\", \"SB\", \"SC\", \"SE\", \"SG\", \"SI\", \"SK\", \"SL\", \"SM\", \"SN\", \"SR\", \"ST\", \"SV\", \"SZ\", \"TD\", \"TG\", \"TH\", \"TJ\", \"TL\", \"TN\", \"TO\", \"TR\", \"TT\", \"TV\", \"TW\", \"TZ\", \"UA\", \"UG\", \"US\", \"UY\", \"UZ\", \"VC\", \"VE\", \"VN\", \"VU\", \"WS\", \"XK\", \"ZA\", \"ZM\", \"ZW\" ],\n" +
                    "        \"external_urls\" : {\n" +
                    "          \"spotify\" : \"https://open.spotify.com/album/0KTj6k94XZh0c6IEMfxeWV\"\n" +
                    "        },\n" +
                    "        \"href\" : \"https://api.spotify.com/v1/albums/0KTj6k94XZh0c6IEMfxeWV\",\n" +
                    "        \"id\" : \"0KTj6k94XZh0c6IEMfxeWV\",\n" +
                    "        \"images\" : [ {\n" +
                    "          \"height\" : 640,\n" +
                    "          \"url\" : \"https://i.scdn.co/image/ab67616d0000b2739e495fb707973f3390850eea\",\n" +
                    "          \"width\" : 640\n" +
                    "        }, {\n" +
                    "          \"height\" : 300,\n" +
                    "          \"url\" : \"https://i.scdn.co/image/ab67616d00001e029e495fb707973f3390850eea\",\n" +
                    "          \"width\" : 300\n" +
                    "        }, {\n" +
                    "          \"height\" : 64,\n" +
                    "          \"url\" : \"https://i.scdn.co/image/ab67616d000048519e495fb707973f3390850eea\",\n" +
                    "          \"width\" : 64\n" +
                    "        } ],\n" +
                    "        \"name\" : \"Dreamland (+ Bonus Levels)\",\n" +
                    "        \"release_date\" : \"2020-08-06\",\n" +
                    "        \"release_date_precision\" : \"day\",\n" +
                    "        \"total_tracks\" : 18,\n" +
                    "        \"type\" : \"album\",\n" +
                    "        \"uri\" : \"spotify:album:0KTj6k94XZh0c6IEMfxeWV\"\n" +
                    "      },\n" +
                    "      \"artists\" : [ {\n" +
                    "        \"external_urls\" : {\n" +
                    "          \"spotify\" : \"https://open.spotify.com/artist/4yvcSjfu4PC0CYQyLy4wSq\"\n" +
                    "        },\n" +
                    "        \"href\" : \"https://api.spotify.com/v1/artists/4yvcSjfu4PC0CYQyLy4wSq\",\n" +
                    "        \"id\" : \"4yvcSjfu4PC0CYQyLy4wSq\",\n" +
                    "        \"name\" : \"Glass Animals\",\n" +
                    "        \"type\" : \"artist\",\n" +
                    "        \"uri\" : \"spotify:artist:4yvcSjfu4PC0CYQyLy4wSq\"\n" +
                    "      } ],\n" +
                    "      \"available_markets\" : [ \"AD\", \"AE\", \"AG\", \"AL\", \"AM\", \"AO\", \"AR\", \"AT\", \"AU\", \"AZ\", \"BA\", \"BB\", \"BD\", \"BE\", \"BF\", \"BG\", \"BH\", \"BI\", \"BJ\", \"BN\", \"BO\", \"BR\", \"BS\", \"BT\", \"BW\", \"BY\", \"BZ\", \"CA\", \"CD\", \"CG\", \"CH\", \"CI\", \"CL\", \"CM\", \"CO\", \"CR\", \"CV\", \"CW\", \"CY\", \"CZ\", \"DE\", \"DJ\", \"DK\", \"DM\", \"DO\", \"DZ\", \"EC\", \"EE\", \"EG\", \"ES\", \"FI\", \"FJ\", \"FM\", \"FR\", \"GA\", \"GB\", \"GD\", \"GE\", \"GH\", \"GM\", \"GN\", \"GQ\", \"GR\", \"GT\", \"GW\", \"GY\", \"HK\", \"HN\", \"HR\", \"HT\", \"HU\", \"ID\", \"IE\", \"IL\", \"IN\", \"IQ\", \"IS\", \"IT\", \"JM\", \"JO\", \"JP\", \"KE\", \"KG\", \"KH\", \"KI\", \"KM\", \"KN\", \"KR\", \"KW\", \"KZ\", \"LA\", \"LB\", \"LC\", \"LI\", \"LK\", \"LR\", \"LS\", \"LT\", \"LU\", \"LV\", \"LY\", \"MA\", \"MC\", \"MD\", \"ME\", \"MG\", \"MH\", \"MK\", \"ML\", \"MN\", \"MO\", \"MR\", \"MT\", \"MU\", \"MV\", \"MW\", \"MX\", \"MY\", \"MZ\", \"NA\", \"NE\", \"NG\", \"NI\", \"NL\", \"NO\", \"NP\", \"NR\", \"NZ\", \"OM\", \"PA\", \"PE\", \"PG\", \"PH\", \"PK\", \"PL\", \"PS\", \"PT\", \"PW\", \"PY\", \"QA\", \"RO\", \"RS\", \"RU\", \"RW\", \"SA\", \"SB\", \"SC\", \"SE\", \"SG\", \"SI\", \"SK\", \"SL\", \"SM\", \"SN\", \"SR\", \"ST\", \"SV\", \"SZ\", \"TD\", \"TG\", \"TH\", \"TJ\", \"TL\", \"TN\", \"TO\", \"TR\", \"TT\", \"TV\", \"TW\", \"TZ\", \"UA\", \"UG\", \"US\", \"UY\", \"UZ\", \"VC\", \"VE\", \"VN\", \"VU\", \"WS\", \"XK\", \"ZA\", \"ZM\", \"ZW\" ],\n" +
                    "      \"disc_number\" : 1,\n" +
                    "      \"duration_ms\" : 238805,\n" +
                    "      \"episode\" : false,\n" +
                    "      \"explicit\" : false,\n" +
                    "      \"external_ids\" : {\n" +
                    "        \"isrc\" : \"GBUM72000433\"\n" +
                    "      },\n" +
                    "      \"external_urls\" : {\n" +
                    "        \"spotify\" : \"https://open.spotify.com/track/02MWAaffLxlfxAUY7c5dvx\"\n" +
                    "      },\n" +
                    "      \"href\" : \"https://api.spotify.com/v1/tracks/02MWAaffLxlfxAUY7c5dvx\",\n" +
                    "      \"id\" : \"02MWAaffLxlfxAUY7c5dvx\",\n" +
                    "      \"is_local\" : false,\n" +
                    "      \"name\" : \"Numb\",\n" +
                    "      \"popularity\" : 96,\n" +
                    "      \"preview_url\" : null,\n" +
                    "      \"track\" : true,\n" +
                    "      \"track_number\" : 14,\n" +
                    "      \"type\" : \"track\",\n" +
                    "      \"uri\" : \"spotify:track:02MWAaffLxlfxAUY7c5dvx\"\n" +
                    "    },\n" +
                    "    \"video_thumbnail\" : {\n" +
                    "      \"url\" : null\n" +
                    "    }\n" +
                    "  }");
            assertEquals("Glass Animals",ss.getArtistName(jo));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getArtistNameTest2(){

        try {
            SpotifyService ss = new SpotifyService();
            JSONObject jo = new JSONObject("{\n" +
                    "    \"added_at\" : \"2022-04-01T11:11:54Z\",\n" +
                    "    \"added_by\" : {\n" +
                    "      \"external_urls\" : {\n" +
                    "        \"spotify\" : \"https://open.spotify.com/user/\"\n" +
                    "      },\n" +
                    "      \"href\" : \"https://api.spotify.com/v1/users/\",\n" +
                    "      \"id\" : \"\",\n" +
                    "      \"type\" : \"user\",\n" +
                    "      \"uri\" : \"spotify:user:\"\n" +
                    "    },\n" +
                    "    \"is_local\" : false,\n" +
                    "    \"primary_color\" : null,\n" +
                    "    \"track\" : {\n" +
                    "      \"album\" : {\n" +
                    "        \"album_type\" : \"album\",\n" +
                    "        \"artists\" : [ {\n" +
                    "          \"external_urls\" : {\n" +
                    "            \"spotify\" : \"https://open.spotify.com/artist/4yvcSjfu4PC0CYQyLy4wSq\"\n" +
                    "          },\n" +
                    "          \"href\" : \"https://api.spotify.com/v1/artists/4yvcSjfu4PC0CYQyLy4wSq\",\n" +
                    "          \"id\" : \"4yvcSjfu4PC0CYQyLy4wSq\",\n" +
                    "          \"name\" : \"Linkin Park\",\n" +
                    "          \"type\" : \"artist\",\n" +
                    "          \"uri\" : \"spotify:artist:4yvcSjfu4PC0CYQyLy4wSq\"\n" +
                    "        } ],\n" +
                    "        \"available_markets\" : [ \"AD\", \"AE\", \"AG\", \"AL\", \"AM\", \"AO\", \"AR\", \"AT\", \"AU\", \"AZ\", \"BA\", \"BB\", \"BD\", \"BE\", \"BF\", \"BG\", \"BH\", \"BI\", \"BJ\", \"BN\", \"BO\", \"BR\", \"BS\", \"BT\", \"BW\", \"BY\", \"BZ\", \"CA\", \"CD\", \"CG\", \"CH\", \"CI\", \"CL\", \"CM\", \"CO\", \"CR\", \"CV\", \"CW\", \"CY\", \"CZ\", \"DE\", \"DJ\", \"DK\", \"DM\", \"DO\", \"DZ\", \"EC\", \"EE\", \"EG\", \"ES\", \"FI\", \"FJ\", \"FM\", \"FR\", \"GA\", \"GB\", \"GD\", \"GE\", \"GH\", \"GM\", \"GN\", \"GQ\", \"GR\", \"GT\", \"GW\", \"GY\", \"HK\", \"HN\", \"HR\", \"HT\", \"HU\", \"ID\", \"IE\", \"IL\", \"IN\", \"IQ\", \"IS\", \"IT\", \"JM\", \"JO\", \"JP\", \"KE\", \"KG\", \"KH\", \"KI\", \"KM\", \"KN\", \"KR\", \"KW\", \"KZ\", \"LA\", \"LB\", \"LC\", \"LI\", \"LK\", \"LR\", \"LS\", \"LT\", \"LU\", \"LV\", \"LY\", \"MA\", \"MC\", \"MD\", \"ME\", \"MG\", \"MH\", \"MK\", \"ML\", \"MN\", \"MO\", \"MR\", \"MT\", \"MU\", \"MV\", \"MW\", \"MX\", \"MY\", \"MZ\", \"NA\", \"NE\", \"NG\", \"NI\", \"NL\", \"NO\", \"NP\", \"NR\", \"NZ\", \"OM\", \"PA\", \"PE\", \"PG\", \"PH\", \"PK\", \"PL\", \"PS\", \"PT\", \"PW\", \"PY\", \"QA\", \"RO\", \"RS\", \"RU\", \"RW\", \"SA\", \"SB\", \"SC\", \"SE\", \"SG\", \"SI\", \"SK\", \"SL\", \"SM\", \"SN\", \"SR\", \"ST\", \"SV\", \"SZ\", \"TD\", \"TG\", \"TH\", \"TJ\", \"TL\", \"TN\", \"TO\", \"TR\", \"TT\", \"TV\", \"TW\", \"TZ\", \"UA\", \"UG\", \"US\", \"UY\", \"UZ\", \"VC\", \"VE\", \"VN\", \"VU\", \"WS\", \"XK\", \"ZA\", \"ZM\", \"ZW\" ],\n" +
                    "        \"external_urls\" : {\n" +
                    "          \"spotify\" : \"https://open.spotify.com/album/0KTj6k94XZh0c6IEMfxeWV\"\n" +
                    "        },\n" +
                    "        \"href\" : \"https://api.spotify.com/v1/albums/0KTj6k94XZh0c6IEMfxeWV\",\n" +
                    "        \"id\" : \"0KTj6k94XZh0c6IEMfxeWV\",\n" +
                    "        \"images\" : [ {\n" +
                    "          \"height\" : 640,\n" +
                    "          \"url\" : \"https://i.scdn.co/image/ab67616d0000b2739e495fb707973f3390850eea\",\n" +
                    "          \"width\" : 640\n" +
                    "        }, {\n" +
                    "          \"height\" : 300,\n" +
                    "          \"url\" : \"https://i.scdn.co/image/ab67616d00001e029e495fb707973f3390850eea\",\n" +
                    "          \"width\" : 300\n" +
                    "        }, {\n" +
                    "          \"height\" : 64,\n" +
                    "          \"url\" : \"https://i.scdn.co/image/ab67616d000048519e495fb707973f3390850eea\",\n" +
                    "          \"width\" : 64\n" +
                    "        } ],\n" +
                    "        \"name\" : \"Dreamland (+ Bonus Levels)\",\n" +
                    "        \"release_date\" : \"2020-08-06\",\n" +
                    "        \"release_date_precision\" : \"day\",\n" +
                    "        \"total_tracks\" : 18,\n" +
                    "        \"type\" : \"album\",\n" +
                    "        \"uri\" : \"spotify:album:0KTj6k94XZh0c6IEMfxeWV\"\n" +
                    "      },\n" +
                    "      \"artists\" : [ {\n" +
                    "        \"external_urls\" : {\n" +
                    "          \"spotify\" : \"https://open.spotify.com/artist/4yvcSjfu4PC0CYQyLy4wSq\"\n" +
                    "        },\n" +
                    "        \"href\" : \"https://api.spotify.com/v1/artists/4yvcSjfu4PC0CYQyLy4wSq\",\n" +
                    "        \"id\" : \"4yvcSjfu4PC0CYQyLy4wSq\",\n" +
                    "        \"name\" : \"Linkin Park\",\n" +
                    "        \"type\" : \"artist\",\n" +
                    "        \"uri\" : \"spotify:artist:4yvcSjfu4PC0CYQyLy4wSq\"\n" +
                    "      } ],\n" +
                    "      \"available_markets\" : [ \"AD\", \"AE\", \"AG\", \"AL\", \"AM\", \"AO\", \"AR\", \"AT\", \"AU\", \"AZ\", \"BA\", \"BB\", \"BD\", \"BE\", \"BF\", \"BG\", \"BH\", \"BI\", \"BJ\", \"BN\", \"BO\", \"BR\", \"BS\", \"BT\", \"BW\", \"BY\", \"BZ\", \"CA\", \"CD\", \"CG\", \"CH\", \"CI\", \"CL\", \"CM\", \"CO\", \"CR\", \"CV\", \"CW\", \"CY\", \"CZ\", \"DE\", \"DJ\", \"DK\", \"DM\", \"DO\", \"DZ\", \"EC\", \"EE\", \"EG\", \"ES\", \"FI\", \"FJ\", \"FM\", \"FR\", \"GA\", \"GB\", \"GD\", \"GE\", \"GH\", \"GM\", \"GN\", \"GQ\", \"GR\", \"GT\", \"GW\", \"GY\", \"HK\", \"HN\", \"HR\", \"HT\", \"HU\", \"ID\", \"IE\", \"IL\", \"IN\", \"IQ\", \"IS\", \"IT\", \"JM\", \"JO\", \"JP\", \"KE\", \"KG\", \"KH\", \"KI\", \"KM\", \"KN\", \"KR\", \"KW\", \"KZ\", \"LA\", \"LB\", \"LC\", \"LI\", \"LK\", \"LR\", \"LS\", \"LT\", \"LU\", \"LV\", \"LY\", \"MA\", \"MC\", \"MD\", \"ME\", \"MG\", \"MH\", \"MK\", \"ML\", \"MN\", \"MO\", \"MR\", \"MT\", \"MU\", \"MV\", \"MW\", \"MX\", \"MY\", \"MZ\", \"NA\", \"NE\", \"NG\", \"NI\", \"NL\", \"NO\", \"NP\", \"NR\", \"NZ\", \"OM\", \"PA\", \"PE\", \"PG\", \"PH\", \"PK\", \"PL\", \"PS\", \"PT\", \"PW\", \"PY\", \"QA\", \"RO\", \"RS\", \"RU\", \"RW\", \"SA\", \"SB\", \"SC\", \"SE\", \"SG\", \"SI\", \"SK\", \"SL\", \"SM\", \"SN\", \"SR\", \"ST\", \"SV\", \"SZ\", \"TD\", \"TG\", \"TH\", \"TJ\", \"TL\", \"TN\", \"TO\", \"TR\", \"TT\", \"TV\", \"TW\", \"TZ\", \"UA\", \"UG\", \"US\", \"UY\", \"UZ\", \"VC\", \"VE\", \"VN\", \"VU\", \"WS\", \"XK\", \"ZA\", \"ZM\", \"ZW\" ],\n" +
                    "      \"disc_number\" : 1,\n" +
                    "      \"duration_ms\" : 238805,\n" +
                    "      \"episode\" : false,\n" +
                    "      \"explicit\" : false,\n" +
                    "      \"external_ids\" : {\n" +
                    "        \"isrc\" : \"GBUM72000433\"\n" +
                    "      },\n" +
                    "      \"external_urls\" : {\n" +
                    "        \"spotify\" : \"https://open.spotify.com/track/02MWAaffLxlfxAUY7c5dvx\"\n" +
                    "      },\n" +
                    "      \"href\" : \"https://api.spotify.com/v1/tracks/02MWAaffLxlfxAUY7c5dvx\",\n" +
                    "      \"id\" : \"02MWAaffLxlfxAUY7c5dvx\",\n" +
                    "      \"is_local\" : false,\n" +
                    "      \"name\" : \"Numb\",\n" +
                    "      \"popularity\" : 96,\n" +
                    "      \"preview_url\" : null,\n" +
                    "      \"track\" : true,\n" +
                    "      \"track_number\" : 14,\n" +
                    "      \"type\" : \"track\",\n" +
                    "      \"uri\" : \"spotify:track:02MWAaffLxlfxAUY7c5dvx\"\n" +
                    "    },\n" +
                    "    \"video_thumbnail\" : {\n" +
                    "      \"url\" : null\n" +
                    "    }\n" +
                    "  }");
            assertEquals("Linkin Park",ss.getArtistName(jo));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getArtistNameTest3(){

        try {
            SpotifyService ss = new SpotifyService();
            JSONObject jo = new JSONObject("{\n" +
                    "    \"added_at\" : \"2022-04-01T11:11:54Z\",\n" +
                    "    \"added_by\" : {\n" +
                    "      \"external_urls\" : {\n" +
                    "        \"spotify\" : \"https://open.spotify.com/user/\"\n" +
                    "      },\n" +
                    "      \"href\" : \"https://api.spotify.com/v1/users/\",\n" +
                    "      \"id\" : \"\",\n" +
                    "      \"type\" : \"user\",\n" +
                    "      \"uri\" : \"spotify:user:\"\n" +
                    "    },\n" +
                    "    \"is_local\" : false,\n" +
                    "    \"primary_color\" : null,\n" +
                    "    \"track\" : {\n" +
                    "      \"album\" : {\n" +
                    "        \"album_type\" : \"album\",\n" +
                    "        \"artists\" : [ {\n" +
                    "          \"external_urls\" : {\n" +
                    "            \"spotify\" : \"https://open.spotify.com/artist/4yvcSjfu4PC0CYQyLy4wSq\"\n" +
                    "          },\n" +
                    "          \"href\" : \"https://api.spotify.com/v1/artists/4yvcSjfu4PC0CYQyLy4wSq\",\n" +
                    "          \"id\" : \"4yvcSjfu4PC0CYQyLy4wSq\",\n" +
                    "          \"name\" : \"Bon Jovi\",\n" +
                    "          \"type\" : \"artist\",\n" +
                    "          \"uri\" : \"spotify:artist:4yvcSjfu4PC0CYQyLy4wSq\"\n" +
                    "        } ],\n" +
                    "        \"available_markets\" : [ \"AD\", \"AE\", \"AG\", \"AL\", \"AM\", \"AO\", \"AR\", \"AT\", \"AU\", \"AZ\", \"BA\", \"BB\", \"BD\", \"BE\", \"BF\", \"BG\", \"BH\", \"BI\", \"BJ\", \"BN\", \"BO\", \"BR\", \"BS\", \"BT\", \"BW\", \"BY\", \"BZ\", \"CA\", \"CD\", \"CG\", \"CH\", \"CI\", \"CL\", \"CM\", \"CO\", \"CR\", \"CV\", \"CW\", \"CY\", \"CZ\", \"DE\", \"DJ\", \"DK\", \"DM\", \"DO\", \"DZ\", \"EC\", \"EE\", \"EG\", \"ES\", \"FI\", \"FJ\", \"FM\", \"FR\", \"GA\", \"GB\", \"GD\", \"GE\", \"GH\", \"GM\", \"GN\", \"GQ\", \"GR\", \"GT\", \"GW\", \"GY\", \"HK\", \"HN\", \"HR\", \"HT\", \"HU\", \"ID\", \"IE\", \"IL\", \"IN\", \"IQ\", \"IS\", \"IT\", \"JM\", \"JO\", \"JP\", \"KE\", \"KG\", \"KH\", \"KI\", \"KM\", \"KN\", \"KR\", \"KW\", \"KZ\", \"LA\", \"LB\", \"LC\", \"LI\", \"LK\", \"LR\", \"LS\", \"LT\", \"LU\", \"LV\", \"LY\", \"MA\", \"MC\", \"MD\", \"ME\", \"MG\", \"MH\", \"MK\", \"ML\", \"MN\", \"MO\", \"MR\", \"MT\", \"MU\", \"MV\", \"MW\", \"MX\", \"MY\", \"MZ\", \"NA\", \"NE\", \"NG\", \"NI\", \"NL\", \"NO\", \"NP\", \"NR\", \"NZ\", \"OM\", \"PA\", \"PE\", \"PG\", \"PH\", \"PK\", \"PL\", \"PS\", \"PT\", \"PW\", \"PY\", \"QA\", \"RO\", \"RS\", \"RU\", \"RW\", \"SA\", \"SB\", \"SC\", \"SE\", \"SG\", \"SI\", \"SK\", \"SL\", \"SM\", \"SN\", \"SR\", \"ST\", \"SV\", \"SZ\", \"TD\", \"TG\", \"TH\", \"TJ\", \"TL\", \"TN\", \"TO\", \"TR\", \"TT\", \"TV\", \"TW\", \"TZ\", \"UA\", \"UG\", \"US\", \"UY\", \"UZ\", \"VC\", \"VE\", \"VN\", \"VU\", \"WS\", \"XK\", \"ZA\", \"ZM\", \"ZW\" ],\n" +
                    "        \"external_urls\" : {\n" +
                    "          \"spotify\" : \"https://open.spotify.com/album/0KTj6k94XZh0c6IEMfxeWV\"\n" +
                    "        },\n" +
                    "        \"href\" : \"https://api.spotify.com/v1/albums/0KTj6k94XZh0c6IEMfxeWV\",\n" +
                    "        \"id\" : \"0KTj6k94XZh0c6IEMfxeWV\",\n" +
                    "        \"images\" : [ {\n" +
                    "          \"height\" : 640,\n" +
                    "          \"url\" : \"https://i.scdn.co/image/ab67616d0000b2739e495fb707973f3390850eea\",\n" +
                    "          \"width\" : 640\n" +
                    "        }, {\n" +
                    "          \"height\" : 300,\n" +
                    "          \"url\" : \"https://i.scdn.co/image/ab67616d00001e029e495fb707973f3390850eea\",\n" +
                    "          \"width\" : 300\n" +
                    "        }, {\n" +
                    "          \"height\" : 64,\n" +
                    "          \"url\" : \"https://i.scdn.co/image/ab67616d000048519e495fb707973f3390850eea\",\n" +
                    "          \"width\" : 64\n" +
                    "        } ],\n" +
                    "        \"name\" : \"Dreamland (+ Bonus Levels)\",\n" +
                    "        \"release_date\" : \"2020-08-06\",\n" +
                    "        \"release_date_precision\" : \"day\",\n" +
                    "        \"total_tracks\" : 18,\n" +
                    "        \"type\" : \"album\",\n" +
                    "        \"uri\" : \"spotify:album:0KTj6k94XZh0c6IEMfxeWV\"\n" +
                    "      },\n" +
                    "      \"artists\" : [ {\n" +
                    "        \"external_urls\" : {\n" +
                    "          \"spotify\" : \"https://open.spotify.com/artist/4yvcSjfu4PC0CYQyLy4wSq\"\n" +
                    "        },\n" +
                    "        \"href\" : \"https://api.spotify.com/v1/artists/4yvcSjfu4PC0CYQyLy4wSq\",\n" +
                    "        \"id\" : \"4yvcSjfu4PC0CYQyLy4wSq\",\n" +
                    "        \"name\" : \"Bon Jovi\",\n" +
                    "        \"type\" : \"artist\",\n" +
                    "        \"uri\" : \"spotify:artist:4yvcSjfu4PC0CYQyLy4wSq\"\n" +
                    "      } ],\n" +
                    "      \"available_markets\" : [ \"AD\", \"AE\", \"AG\", \"AL\", \"AM\", \"AO\", \"AR\", \"AT\", \"AU\", \"AZ\", \"BA\", \"BB\", \"BD\", \"BE\", \"BF\", \"BG\", \"BH\", \"BI\", \"BJ\", \"BN\", \"BO\", \"BR\", \"BS\", \"BT\", \"BW\", \"BY\", \"BZ\", \"CA\", \"CD\", \"CG\", \"CH\", \"CI\", \"CL\", \"CM\", \"CO\", \"CR\", \"CV\", \"CW\", \"CY\", \"CZ\", \"DE\", \"DJ\", \"DK\", \"DM\", \"DO\", \"DZ\", \"EC\", \"EE\", \"EG\", \"ES\", \"FI\", \"FJ\", \"FM\", \"FR\", \"GA\", \"GB\", \"GD\", \"GE\", \"GH\", \"GM\", \"GN\", \"GQ\", \"GR\", \"GT\", \"GW\", \"GY\", \"HK\", \"HN\", \"HR\", \"HT\", \"HU\", \"ID\", \"IE\", \"IL\", \"IN\", \"IQ\", \"IS\", \"IT\", \"JM\", \"JO\", \"JP\", \"KE\", \"KG\", \"KH\", \"KI\", \"KM\", \"KN\", \"KR\", \"KW\", \"KZ\", \"LA\", \"LB\", \"LC\", \"LI\", \"LK\", \"LR\", \"LS\", \"LT\", \"LU\", \"LV\", \"LY\", \"MA\", \"MC\", \"MD\", \"ME\", \"MG\", \"MH\", \"MK\", \"ML\", \"MN\", \"MO\", \"MR\", \"MT\", \"MU\", \"MV\", \"MW\", \"MX\", \"MY\", \"MZ\", \"NA\", \"NE\", \"NG\", \"NI\", \"NL\", \"NO\", \"NP\", \"NR\", \"NZ\", \"OM\", \"PA\", \"PE\", \"PG\", \"PH\", \"PK\", \"PL\", \"PS\", \"PT\", \"PW\", \"PY\", \"QA\", \"RO\", \"RS\", \"RU\", \"RW\", \"SA\", \"SB\", \"SC\", \"SE\", \"SG\", \"SI\", \"SK\", \"SL\", \"SM\", \"SN\", \"SR\", \"ST\", \"SV\", \"SZ\", \"TD\", \"TG\", \"TH\", \"TJ\", \"TL\", \"TN\", \"TO\", \"TR\", \"TT\", \"TV\", \"TW\", \"TZ\", \"UA\", \"UG\", \"US\", \"UY\", \"UZ\", \"VC\", \"VE\", \"VN\", \"VU\", \"WS\", \"XK\", \"ZA\", \"ZM\", \"ZW\" ],\n" +
                    "      \"disc_number\" : 1,\n" +
                    "      \"duration_ms\" : 238805,\n" +
                    "      \"episode\" : false,\n" +
                    "      \"explicit\" : false,\n" +
                    "      \"external_ids\" : {\n" +
                    "        \"isrc\" : \"GBUM72000433\"\n" +
                    "      },\n" +
                    "      \"external_urls\" : {\n" +
                    "        \"spotify\" : \"https://open.spotify.com/track/02MWAaffLxlfxAUY7c5dvx\"\n" +
                    "      },\n" +
                    "      \"href\" : \"https://api.spotify.com/v1/tracks/02MWAaffLxlfxAUY7c5dvx\",\n" +
                    "      \"id\" : \"02MWAaffLxlfxAUY7c5dvx\",\n" +
                    "      \"is_local\" : false,\n" +
                    "      \"name\" : \"Numb\",\n" +
                    "      \"popularity\" : 96,\n" +
                    "      \"preview_url\" : null,\n" +
                    "      \"track\" : true,\n" +
                    "      \"track_number\" : 14,\n" +
                    "      \"type\" : \"track\",\n" +
                    "      \"uri\" : \"spotify:track:02MWAaffLxlfxAUY7c5dvx\"\n" +
                    "    },\n" +
                    "    \"video_thumbnail\" : {\n" +
                    "      \"url\" : null\n" +
                    "    }\n" +
                    "  }");
            assertEquals("Bon Jovi",ss.getArtistName(jo));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }


}